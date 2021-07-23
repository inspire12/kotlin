/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.frontend.api.fir.components

import org.jetbrains.kotlin.builtins.StandardNames
import org.jetbrains.kotlin.fir.FirSourceElement
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirDiagnostic
import org.jetbrains.kotlin.fir.expressions.*
import org.jetbrains.kotlin.fir.realPsi
import org.jetbrains.kotlin.fir.references.FirErrorNamedReference
import org.jetbrains.kotlin.fir.references.FirReference
import org.jetbrains.kotlin.fir.references.FirResolvedNamedReference
import org.jetbrains.kotlin.fir.references.impl.FirSimpleNamedReference
import org.jetbrains.kotlin.fir.resolve.calls.FirErrorReferenceWithCandidate
import org.jetbrains.kotlin.fir.symbols.impl.FirNamedFunctionSymbol
import org.jetbrains.kotlin.idea.fir.getCandidateSymbols
import org.jetbrains.kotlin.idea.fir.isImplicitFunctionCall
import org.jetbrains.kotlin.idea.fir.low.level.api.api.getOrBuildFir
import org.jetbrains.kotlin.idea.frontend.api.calls.*
import org.jetbrains.kotlin.idea.frontend.api.components.KtCallResolver
import org.jetbrains.kotlin.idea.frontend.api.diagnostics.KtNonBoundToPsiErrorDiagnostic
import org.jetbrains.kotlin.idea.frontend.api.fir.KtFirAnalysisSession
import org.jetbrains.kotlin.idea.frontend.api.fir.buildSymbol
import org.jetbrains.kotlin.idea.frontend.api.symbols.KtFunctionLikeSymbol
import org.jetbrains.kotlin.idea.frontend.api.symbols.KtFunctionSymbol
import org.jetbrains.kotlin.idea.frontend.api.symbols.KtValueParameterSymbol
import org.jetbrains.kotlin.idea.frontend.api.symbols.KtVariableLikeSymbol
import org.jetbrains.kotlin.idea.frontend.api.tokens.ValidityToken
import org.jetbrains.kotlin.idea.frontend.api.withValidityAssertion
import org.jetbrains.kotlin.idea.references.FirReferenceResolveHelper
import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.util.OperatorNameConventions
import org.jetbrains.kotlin.utils.addToStdlib.safeAs

internal class KtFirCallResolver(
    override val analysisSession: KtFirAnalysisSession,
    override val token: ValidityToken,
) : KtCallResolver(), KtFirAnalysisSessionComponent {
    private val diagnosticCache = mutableListOf<FirDiagnostic>()

    override fun resolveCall(call: KtBinaryExpression): KtCall? = withValidityAssertion {
        when (val fir = call.getOrBuildFir(firResolveState)) {
            is FirFunctionCall -> resolveCall(fir)
            is FirComparisonExpression -> resolveCall(fir.compareToCall)
            is FirEqualityOperatorCall -> null // TODO
            else -> null
        }
    }

    override fun resolveCall(call: KtUnaryExpression): KtCall? = withValidityAssertion {
        when (val fir = call.getOrBuildFir(firResolveState)) {
            is FirFunctionCall -> resolveCall(fir)
            is FirBlock -> {
                // Desugared increment or decrement block. See [BaseFirBuilder#generateIncrementOrDecrementBlock]
                // There would be corresponding inc()/dec() call that is assigned back to a temp variable.
                val prefix = fir.statements.filterIsInstance<FirVariableAssignment>().find { it.rValue is FirFunctionCall }
                (prefix?.rValue as? FirFunctionCall)?.let { resolveCall(it) }
            }
            is FirCheckNotNullCall -> null // TODO
            else -> null
        }
    }

    override fun resolveCall(call: KtCallElement): KtCall? = withValidityAssertion {
        return when (val fir = call.getOrBuildFir(firResolveState)) {
            is FirFunctionCall -> resolveCall(fir)
            is FirAnnotationCall -> fir.asAnnotationCall()
            is FirDelegatedConstructorCall -> fir.asDelegatedConstructorCall()
            is FirSafeCallExpression -> fir.regularQualifiedAccess.safeAs<FirFunctionCall>()?.let { resolveCall(it) }
            else -> null
        }
    }

    private fun resolveCall(firCall: FirFunctionCall): KtCall? {
        val session = firResolveState.rootModuleSession
        return when {
            firCall.isImplicitFunctionCall() -> {
                val target = with(FirReferenceResolveHelper) {
                    val calleeReference = (firCall.dispatchReceiver as FirQualifiedAccessExpression).calleeReference
                    calleeReference.toTargetSymbol(session, firSymbolBuilder).singleOrNull()
                }
                when (target) {
                    is KtVariableLikeSymbol -> firCall.createCallByVariableLikeSymbolCall(target)
                    null -> null
                    else -> firCall.asSimpleFunctionCall()
                }
            }
            else -> firCall.asSimpleFunctionCall()
        }
    }

    private fun FirFunctionCall.createCallByVariableLikeSymbolCall(variableLikeSymbol: KtVariableLikeSymbol): KtCall? {
        return when (val callReference = calleeReference) {
            is FirResolvedNamedReference -> {
                val functionSymbol = callReference.resolvedSymbol as? FirNamedFunctionSymbol
                val callableId = functionSymbol?.callableId ?: return null
                (callReference.resolvedSymbol.fir.buildSymbol(firSymbolBuilder) as? KtFunctionSymbol)
                    ?.let {
                        if (callableId in kotlinFunctionInvokeCallableIds) {
                            KtFunctionalTypeVariableCall(variableLikeSymbol, KtSuccessCallTarget(it))
                        } else {
                            KtVariableWithInvokeFunctionCall(variableLikeSymbol, KtSuccessCallTarget(it))
                        }
                    }
            }
            is FirErrorNamedReference -> KtVariableWithInvokeFunctionCall(
                variableLikeSymbol,
                callReference.createErrorCallTarget(source)
            )
            else -> error("Unexpected call reference ${callReference::class.simpleName}")
        }
    }

    private fun FirFunctionCall.asSimpleFunctionCall(): KtFunctionCall? {
        val target = calleeReference.createCallTarget() ?: return null
        return KtFunctionCall(createArgumentMapping(), target)
    }

    private fun FirAnnotationCall.asAnnotationCall(): KtAnnotationCall? {
        val target = calleeReference.createCallTarget() ?: return null
        return KtAnnotationCall(createArgumentMapping(), target)
    }

    private fun FirDelegatedConstructorCall.asDelegatedConstructorCall(): KtDelegatedConstructorCall? {
        val target = calleeReference.createCallTarget() ?: return null
        val kind = if (isSuper) KtDelegatedConstructorCallKind.SUPER_CALL else KtDelegatedConstructorCallKind.THIS_CALL
        return KtDelegatedConstructorCall(createArgumentMapping(), target, kind)
    }

    private fun FirReference.createCallTarget(): KtCallTarget? {
        return when (this) {
            is FirResolvedNamedReference -> getKtFunctionOrConstructorSymbol()?.let { KtSuccessCallTarget(it) }
            is FirErrorNamedReference -> createErrorCallTarget(source)
            is FirErrorReferenceWithCandidate -> createErrorCallTarget(source)
            is FirSimpleNamedReference ->
                null
            /*  error(
                  """
                    Looks like ${this::class.simpleName} && it calle reference ${calleeReference::class.simpleName} were not resolved to BODY_RESOLVE phase,
                    consider resolving it containing declaration before starting resolve calls
                    ${this.render()}
                    ${(this.psi as? KtElement)?.getElementTextInContext()}
                    """.trimIndent()
              )*/
            else -> error("Unexpected call reference ${this::class.simpleName}")
        }
    }

    private fun FirCall.createArgumentMapping(): LinkedHashMap<KtValueArgument, KtValueParameterSymbol> {
        val ktArgumentMapping = LinkedHashMap<KtValueArgument, KtValueParameterSymbol>()
        argumentMapping?.let {
            fun FirExpression.findKtValueArgument(): KtValueArgument? {
                // For spread and named arguments, the source is the KtValueArgument.
                // For other arguments, the source is the KtExpression itself and its parent should be the KtValueArgument.
                val psi = when (this) {
                    is FirNamedArgumentExpression, is FirSpreadArgumentExpression -> realPsi
                    else -> realPsi?.parent
                }
                return psi as? KtValueArgument
            }

            for ((firExpression, firValueParameter) in it.entries) {
                val parameterSymbol = firValueParameter.buildSymbol(firSymbolBuilder) as KtValueParameterSymbol
                if (firExpression is FirVarargArgumentsExpression) {
                    for (varargArgument in firExpression.arguments) {
                        val valueArgument = varargArgument.findKtValueArgument() ?: continue
                        ktArgumentMapping[valueArgument] = parameterSymbol
                    }
                } else {
                    val valueArgument = firExpression.findKtValueArgument() ?: continue
                    ktArgumentMapping[valueArgument] = parameterSymbol
                }
            }
        }
        return ktArgumentMapping
    }

    private fun FirErrorNamedReference.createErrorCallTarget(qualifiedAccessSource: FirSourceElement?): KtErrorCallTarget =
        KtErrorCallTarget(
            getCandidateSymbols().mapNotNull { it.fir.buildSymbol(firSymbolBuilder) as? KtFunctionLikeSymbol },
            source?.let { diagnostic.asKtDiagnostic(it, qualifiedAccessSource, diagnosticCache) }
                ?: KtNonBoundToPsiErrorDiagnostic(factoryName = null, diagnostic.reason, token)
        )

    private fun FirErrorReferenceWithCandidate.createErrorCallTarget(qualifiedAccessSource: FirSourceElement?): KtErrorCallTarget =
        KtErrorCallTarget(
            getCandidateSymbols().mapNotNull { it.fir.buildSymbol(firSymbolBuilder) as? KtFunctionLikeSymbol },
            source?.let { diagnostic.asKtDiagnostic(it, qualifiedAccessSource, diagnosticCache) }
                ?: KtNonBoundToPsiErrorDiagnostic(factoryName = null, diagnostic.reason, token)
        )

    private fun FirResolvedNamedReference.getKtFunctionOrConstructorSymbol(): KtFunctionLikeSymbol? =
        resolvedSymbol.fir.buildSymbol(firSymbolBuilder) as? KtFunctionLikeSymbol

    companion object {
        private val kotlinFunctionInvokeCallableIds = (0..23).flatMapTo(hashSetOf()) { arity ->
            listOf(
                CallableId(StandardNames.getFunctionClassId(arity), OperatorNameConventions.INVOKE),
                CallableId(StandardNames.getSuspendFunctionClassId(arity), OperatorNameConventions.INVOKE)
            )
        }
    }
}
