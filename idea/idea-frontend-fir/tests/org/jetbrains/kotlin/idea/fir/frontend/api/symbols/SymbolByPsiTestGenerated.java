/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.fir.frontend.api.symbols;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link GenerateNewCompilerTests.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/idea-frontend-fir/testData/symbols/symbolByPsi")
@TestDataPath("$PROJECT_ROOT")
public class SymbolByPsiTestGenerated extends AbstractSymbolByPsiTest {
    @Test
    public void testAllFilesPresentInSymbolByPsi() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/idea-frontend-fir/testData/symbols/symbolByPsi"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("annotations.kt")
    public void testAnnotations() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/annotations.kt");
    }

    @Test
    @TestMetadata("anonymousObject.kt")
    public void testAnonymousObject() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/anonymousObject.kt");
    }

    @Test
    @TestMetadata("class.kt")
    public void testClass() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/class.kt");
    }

    @Test
    @TestMetadata("classMembes.kt")
    public void testClassMembes() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/classMembes.kt");
    }

    @Test
    @TestMetadata("classPrimaryConstructor.kt")
    public void testClassPrimaryConstructor() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/classPrimaryConstructor.kt");
    }

    @Test
    @TestMetadata("classSecondaryConstructors.kt")
    public void testClassSecondaryConstructors() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/classSecondaryConstructors.kt");
    }

    @Test
    @TestMetadata("classWithTypeParams.kt")
    public void testClassWithTypeParams() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/classWithTypeParams.kt");
    }

    @Test
    @TestMetadata("enum.kt")
    public void testEnum() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/enum.kt");
    }

    @Test
    @TestMetadata("extensionFunction.kt")
    public void testExtensionFunction() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/extensionFunction.kt");
    }

    @Test
    @TestMetadata("function.kt")
    public void testFunction() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/function.kt");
    }

    @Test
    @TestMetadata("functionWithTypeParams.kt")
    public void testFunctionWithTypeParams() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/functionWithTypeParams.kt");
    }

    @Test
    @TestMetadata("implicitReturn.kt")
    public void testImplicitReturn() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/implicitReturn.kt");
    }

    @Test
    @TestMetadata("implicitReturnInLambda.kt")
    public void testImplicitReturnInLambda() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/implicitReturnInLambda.kt");
    }

    @Test
    @TestMetadata("localDeclarations.kt")
    public void testLocalDeclarations() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/localDeclarations.kt");
    }

    @Test
    @TestMetadata("memberFunctions.kt")
    public void testMemberFunctions() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/memberFunctions.kt");
    }

    @Test
    @TestMetadata("memberProperties.kt")
    public void testMemberProperties() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/memberProperties.kt");
    }

    @Test
    @TestMetadata("outerAndInnerClasses.kt")
    public void testOuterAndInnerClasses() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/outerAndInnerClasses.kt");
    }

    @Test
    @TestMetadata("topLevelFunctions.kt")
    public void testTopLevelFunctions() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/topLevelFunctions.kt");
    }

    @Test
    @TestMetadata("topLevelProperties.kt")
    public void testTopLevelProperties() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/topLevelProperties.kt");
    }

    @Test
    @TestMetadata("typeAlias.kt")
    public void testTypeAlias() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/typeAlias.kt");
    }

    @Test
    @TestMetadata("typeAnnotations.kt")
    public void testTypeAnnotations() throws Exception {
        runTest("idea/idea-frontend-fir/testData/symbols/symbolByPsi/typeAnnotations.kt");
    }
}
