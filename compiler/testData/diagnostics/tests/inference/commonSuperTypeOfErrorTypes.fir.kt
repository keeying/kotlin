// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_PARAMETER -UNCHECKED_CAST

class Foo<T>
class Bar<S>

fun <T> consume(x: Foo<out T>, y: Foo<out T>) {}
fun <T> materialize() = null as T

fun test() {
    consume(
        materialize<<!UPPER_BOUND_VIOLATED!>Foo<Bar<ErrorType>><!>>(),
        materialize<<!UPPER_BOUND_VIOLATED!>Foo<Bar<ErrorType>><!>>()
    )

    <!INAPPLICABLE_CANDIDATE!>consume<!>(
        materialize<<!UPPER_BOUND_VIOLATED!>Foo<Bar<ErrorType>><!>>(),
        materialize<<!UPPER_BOUND_VIOLATED!>Foo<ErrorType><!>>()
    )

}
