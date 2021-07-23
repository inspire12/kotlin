/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations.persistent

import org.jetbrains.kotlin.descriptors.DescriptorVisibility
import org.jetbrains.kotlin.descriptors.TypeAliasDescriptor
import org.jetbrains.kotlin.ir.ObsoleteDescriptorBasedAPI
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.declarations.IrDeclarationParent
import org.jetbrains.kotlin.ir.declarations.IrTypeAlias
import org.jetbrains.kotlin.ir.declarations.IrTypeParameter
import org.jetbrains.kotlin.ir.declarations.persistent.carriers.Carrier
import org.jetbrains.kotlin.ir.declarations.persistent.carriers.TypeAliasCarrier
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.symbols.IrTypeAliasSymbol
import org.jetbrains.kotlin.ir.symbols.IrTypeParameterSymbol
import org.jetbrains.kotlin.ir.types.IrType
import org.jetbrains.kotlin.ir.util.IdSignature
import org.jetbrains.kotlin.name.Name

// Auto-generated by compiler/ir/ir.tree.persistent/generator/src/org/jetbrains/kotlin/ir/persistentIrGenerator/Main.kt. DO NOT EDIT!

internal class PersistentIrTypeAlias(
    override val startOffset: Int,
    override val endOffset: Int,
    override val symbol: IrTypeAliasSymbol,
    override val name: Name,
    override var visibility: DescriptorVisibility,
    expandedType: IrType,
    override val isActual: Boolean,
    origin: IrDeclarationOrigin,
    override val factory: PersistentIrFactory
) : IrTypeAlias(),
    PersistentIrDeclarationBase<TypeAliasCarrier>,
    TypeAliasCarrier {

    init {
        symbol.bind(this)
    }

    override var signature: IdSignature? = factory.currentSignature(this)

    override var lastModified: Int = factory.stageController.currentStage
    override var loweredUpTo: Int = factory.stageController.currentStage
    override var values: Array<Carrier>? = null
    override val createdOn: Int = factory.stageController.currentStage

    override var parentField: IrDeclarationParent? = null
    override var originField: IrDeclarationOrigin = origin
    override var removedOn: Int = Int.MAX_VALUE
    override var annotationsField: List<IrConstructorCall> = emptyList()

    @ObsoleteDescriptorBasedAPI
    override val descriptor: TypeAliasDescriptor
        get() = symbol.descriptor

    override var typeParametersField: List<IrTypeParameter> = emptyList()

    override var typeParametersSymbolField: List<IrTypeParameterSymbol>
        get() = typeParametersField.map { it.symbol }
        set(v) {
            typeParametersField = v.map { it.owner }
        }

    override var typeParameters: List<IrTypeParameter>
        get() = getCarrier().typeParametersField
        set(v) {
            if (typeParameters !== v) {
                setCarrier()
                typeParametersField = v
            }
        }

    override var expandedTypeField: IrType = expandedType

    override var expandedType: IrType
        get() = getCarrier().expandedTypeField
        set(v) {
            if (expandedType !== v) {
                setCarrier()
                expandedTypeField = v
            }
        }
}
