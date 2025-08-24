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

    fooNoinlineCrossinline(
        f0 = {
            println("do something noInlined")
        },
        f1 = {
            println("do something crossinlined")
        })
}

inline fun foo(f: () -> Unit) {
    someFunInsideInlinedFun {
        //error: Cannot inline 'f: () -> Unit' here: it might contain non-local returns.
        // Should add 'crossinline' modifier to parameter declaration 'f: ()'
        f()
    }
}

inline fun fooNoinlineCrossinline(noinline f0: () -> Unit, crossinline f1: () -> Unit) {
    someFunInsideInlinedFun {
        f0()
    }

    someFunInsideInlinedFun {
        f1()
    }
}

fun someFunInsideInlinedFun(f: () -> Unit) {
    f()
}