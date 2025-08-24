//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    inlined {
        println("do something inlined")
    }
}

inline fun inlined(block: () -> Unit) {
    println("before")
    block()
    println("after")
    foo {
        println("do something cross inlined")
    }
}

inline fun foo(crossinline f: () -> Unit) {
    bar { f() }
}

fun bar(f: () -> Unit) {
    f()
}