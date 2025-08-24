//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    inlined {
        println("do something here")
    }
}

inline fun inlined(block: () -> Unit) {
    println("before")
    block()
    println("after")
}