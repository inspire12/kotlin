// FIR_IDENTICAL
// !LANGUAGE: +SuspendConversion
// !DIAGNOSTICS: -UNUSED_PARAMETER
// IGNORE_BACKEND: JVM
// IGNORE_BACKEND: WASM
// IGNORE_BACKEND_FIR: JVM_IR

fun useSuspendVararg(vararg sfn: suspend () -> Unit) {}

fun testSuspendConversionInVarargElementsSome(
    sf1: suspend () -> Unit,
    f2: () -> Unit,
    sf3: suspend () -> Unit
) {
    useSuspendVararg(sf1, f2, sf3)
}

fun testSuspendConversionInVarargElementsAll(
    f1: () -> Unit,
    f2: () -> Unit,
    f3: () -> Unit
) {
    useSuspendVararg(f1, f2, f3)
}

fun box(): String {
    testSuspendConversionInVarargElementsSome({}, {}, {})
    testSuspendConversionInVarargElementsAll({}, {}, {})
    return "OK"
}