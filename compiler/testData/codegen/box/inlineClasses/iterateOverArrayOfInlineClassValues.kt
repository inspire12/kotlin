// !LANGUAGE: +InlineClasses
// WITH_RUNTIME

inline class Foo(val arg: Int)

fun box(): String {
    val arr = arrayOf(Foo(1), Foo(2))
    var sum = 0
    for (el in arr) {
        sum += el.arg
    }

    return if (sum != 3) "Fail" else "OK"
}
