/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.fir.intentions;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@RunWith(JUnit3RunnerWithInners.class)
public class HLIntentionTestGenerated extends AbstractHLIntentionTest {
    @TestMetadata("idea/testData/intentions/addPropertyAccessors")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class AddPropertyAccessors extends AbstractHLIntentionTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        public void testAllFilesPresentInAddPropertyAccessors() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/testData/intentions/addPropertyAccessors"), Pattern.compile("^([\\w\\-_]+)\\.(kt|kts)$"), null, true);
        }

        @TestMetadata("idea/testData/intentions/addPropertyAccessors/both")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Both extends AbstractHLIntentionTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
            }

            @TestMetadata("abstract.kt")
            public void testAbstract() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/abstract.kt");
            }

            public void testAllFilesPresentInBoth() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/testData/intentions/addPropertyAccessors/both"), Pattern.compile("^([\\w\\-_]+)\\.(kt|kts)$"), null, true);
            }

            @TestMetadata("caretNotOnName.kt")
            public void testCaretNotOnName() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/caretNotOnName.kt");
            }

            @TestMetadata("delegate.kt")
            public void testDelegate() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/delegate.kt");
            }

            @TestMetadata("expect.kt")
            public void testExpect() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/expect.kt");
            }

            @TestMetadata("hasAccessor.kt")
            public void testHasAccessor() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/hasAccessor.kt");
            }

            @TestMetadata("hasGetter.kt")
            public void testHasGetter() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/hasGetter.kt");
            }

            @TestMetadata("hasSetter.kt")
            public void testHasSetter() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/hasSetter.kt");
            }

            @TestMetadata("jvmField.kt")
            public void testJvmField() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/jvmField.kt");
            }

            @TestMetadata("lateinit.kt")
            public void testLateinit() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/lateinit.kt");
            }

            @TestMetadata("local.kt")
            public void testLocal() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/local.kt");
            }

            @TestMetadata("noType.kt")
            public void testNoType() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/noType.kt");
            }

            @TestMetadata("top.kt")
            public void testTop() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/top.kt");
            }

            @TestMetadata("val.kt")
            public void testVal() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/val.kt");
            }

            @TestMetadata("var.kt")
            public void testVar() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/both/var.kt");
            }
        }

        @TestMetadata("idea/testData/intentions/addPropertyAccessors/getter")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Getter extends AbstractHLIntentionTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
            }

            @TestMetadata("abstract.kt")
            public void testAbstract() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/abstract.kt");
            }

            public void testAllFilesPresentInGetter() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/testData/intentions/addPropertyAccessors/getter"), Pattern.compile("^([\\w\\-_]+)\\.(kt|kts)$"), null, true);
            }

            @TestMetadata("caretNotOnName.kt")
            public void testCaretNotOnName() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/caretNotOnName.kt");
            }

            @TestMetadata("const.kt")
            public void testConst() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/const.kt");
            }

            @TestMetadata("delegate.kt")
            public void testDelegate() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/delegate.kt");
            }

            @TestMetadata("expect.kt")
            public void testExpect() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/expect.kt");
            }

            @TestMetadata("hasAccessor.kt")
            public void testHasAccessor() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/hasAccessor.kt");
            }

            @TestMetadata("hasGetter.kt")
            public void testHasGetter() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/hasGetter.kt");
            }

            @TestMetadata("hasSetter.kt")
            public void testHasSetter() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/hasSetter.kt");
            }

            @TestMetadata("jvmField.kt")
            public void testJvmField() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/jvmField.kt");
            }

            @TestMetadata("lateinit.kt")
            public void testLateinit() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/lateinit.kt");
            }

            @TestMetadata("local.kt")
            public void testLocal() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/local.kt");
            }

            @TestMetadata("noType.kt")
            public void testNoType() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/noType.kt");
            }

            @TestMetadata("top.kt")
            public void testTop() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/top.kt");
            }

            @TestMetadata("val.kt")
            public void testVal() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/val.kt");
            }

            @TestMetadata("var.kt")
            public void testVar() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/getter/var.kt");
            }
        }

        @TestMetadata("idea/testData/intentions/addPropertyAccessors/setter")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Setter extends AbstractHLIntentionTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
            }

            @TestMetadata("abstract.kt")
            public void testAbstract() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/abstract.kt");
            }

            public void testAllFilesPresentInSetter() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/testData/intentions/addPropertyAccessors/setter"), Pattern.compile("^([\\w\\-_]+)\\.(kt|kts)$"), null, true);
            }

            @TestMetadata("caretNotOnName.kt")
            public void testCaretNotOnName() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/caretNotOnName.kt");
            }

            @TestMetadata("delegate.kt")
            public void testDelegate() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/delegate.kt");
            }

            @TestMetadata("expect.kt")
            public void testExpect() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/expect.kt");
            }

            @TestMetadata("hasAccessor.kt")
            public void testHasAccessor() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/hasAccessor.kt");
            }

            @TestMetadata("hasGetter.kt")
            public void testHasGetter() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/hasGetter.kt");
            }

            @TestMetadata("hasSetter.kt")
            public void testHasSetter() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/hasSetter.kt");
            }

            @TestMetadata("jvmField.kt")
            public void testJvmField() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/jvmField.kt");
            }

            @TestMetadata("lateinit.kt")
            public void testLateinit() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/lateinit.kt");
            }

            @TestMetadata("local.kt")
            public void testLocal() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/local.kt");
            }

            @TestMetadata("noType.kt")
            public void testNoType() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/noType.kt");
            }

            @TestMetadata("top.kt")
            public void testTop() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/top.kt");
            }

            @TestMetadata("val.kt")
            public void testVal() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/val.kt");
            }

            @TestMetadata("var.kt")
            public void testVar() throws Exception {
                runTest("idea/testData/intentions/addPropertyAccessors/setter/var.kt");
            }
        }
    }

    @TestMetadata("idea/testData/intentions/specifyTypeExplicitly")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class SpecifyTypeExplicitly extends AbstractHLIntentionTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        public void testAllFilesPresentInSpecifyTypeExplicitly() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("idea/testData/intentions/specifyTypeExplicitly"), Pattern.compile("^([\\w\\-_]+)\\.(kt|kts)$"), null, true);
        }

        @TestMetadata("anonymousObject.kt")
        public void testAnonymousObject() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/anonymousObject.kt");
        }

        @TestMetadata("backticked.kt")
        public void testBackticked() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/backticked.kt");
        }

        @TestMetadata("badCaretPosition.kt")
        public void testBadCaretPosition() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/badCaretPosition.kt");
        }

        @TestMetadata("classNameClashing.kt")
        public void testClassNameClashing() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/classNameClashing.kt");
        }

        @TestMetadata("constructor.kt")
        public void testConstructor() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/constructor.kt");
        }

        @TestMetadata("destructuringInLambda.kt")
        public void testDestructuringInLambda() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/destructuringInLambda.kt");
        }

        @TestMetadata("enumType.kt")
        public void testEnumType() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/enumType.kt");
        }

        @TestMetadata("forAsExpression.kt")
        public void testForAsExpression() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/forAsExpression.kt");
        }

        @TestMetadata("functionType.kt")
        public void testFunctionType() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/functionType.kt");
        }

        @TestMetadata("genericClass.kt")
        public void testGenericClass() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/genericClass.kt");
        }

        @TestMetadata("genericClassWithTypeParameters.kt")
        public void testGenericClassWithTypeParameters() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/genericClassWithTypeParameters.kt");
        }

        @TestMetadata("genericClassWithTypeParameters2.kt")
        public void testGenericClassWithTypeParameters2() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/genericClassWithTypeParameters2.kt");
        }

        @TestMetadata("genericFunction.kt")
        public void testGenericFunction() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/genericFunction.kt");
        }

        @TestMetadata("innerTypeParameter.kt")
        public void testInnerTypeParameter() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/innerTypeParameter.kt");
        }

        @TestMetadata("innerTypeParameter2.kt")
        public void testInnerTypeParameter2() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/innerTypeParameter2.kt");
        }

        @TestMetadata("lambdaParam.kt")
        public void testLambdaParam() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/lambdaParam.kt");
        }

        @TestMetadata("localClass.kt")
        public void testLocalClass() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/localClass.kt");
        }

        @TestMetadata("localClassInSecondTypeParameter.kt")
        public void testLocalClassInSecondTypeParameter() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/localClassInSecondTypeParameter.kt");
        }

        @TestMetadata("localClassInSecondTypeParameter2.kt")
        public void testLocalClassInSecondTypeParameter2() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/localClassInSecondTypeParameter2.kt");
        }

        @TestMetadata("localClassInSecondTypeParameter3.kt")
        public void testLocalClassInSecondTypeParameter3() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/localClassInSecondTypeParameter3.kt");
        }

        @TestMetadata("localClassInTypeParameter.kt")
        public void testLocalClassInTypeParameter() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/localClassInTypeParameter.kt");
        }

        @TestMetadata("loopParameter.kt")
        public void testLoopParameter() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/loopParameter.kt");
        }

        @TestMetadata("outClass.kt")
        public void testOutClass() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/outClass.kt");
        }

        @TestMetadata("outClass2.kt")
        public void testOutClass2() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/outClass2.kt");
        }

        @TestMetadata("outClass3.kt")
        public void testOutClass3() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/outClass3.kt");
        }

        @TestMetadata("overriddenAsNull.kt")
        public void testOverriddenAsNull() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/overriddenAsNull.kt");
        }

        @TestMetadata("overrideNotNullFunction.kt")
        public void testOverrideNotNullFunction() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/overrideNotNullFunction.kt");
        }

        @TestMetadata("overrideNotNullProperty.kt")
        public void testOverrideNotNullProperty() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/overrideNotNullProperty.kt");
        }

        @TestMetadata("overrideNullableFunction.kt")
        public void testOverrideNullableFunction() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/overrideNullableFunction.kt");
        }

        @TestMetadata("overrideNullableProperty.kt")
        public void testOverrideNullableProperty() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/overrideNullableProperty.kt");
        }

        @TestMetadata("propertyTypeFromGetter.kt")
        public void testPropertyTypeFromGetter() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/propertyTypeFromGetter.kt");
        }

        @TestMetadata("publicMember.kt")
        public void testPublicMember() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/publicMember.kt");
        }

        @TestMetadata("stringRedefined.kt")
        public void testStringRedefined() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/stringRedefined.kt");
        }

        @TestMetadata("typeAlreadyProvided.kt")
        public void testTypeAlreadyProvided() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/typeAlreadyProvided.kt");
        }

        @TestMetadata("unitType.kt")
        public void testUnitType() throws Exception {
            runTest("idea/testData/intentions/specifyTypeExplicitly/unitType.kt");
        }
    }
}
