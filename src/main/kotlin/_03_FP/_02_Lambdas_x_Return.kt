package _03_FP

import util.execute

fun main() {
    println("\n-------------------- 0")
    ex0().also { print('\n') }
    execute(::ex1,::ex2,::ex3,::ex4)
}


private fun ex0() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return                     //TODO non-local return directly to the caller of ex0()
        print(it)
    }
    println("this point is unreachable")
}

private fun ex1() {
    listOf(1, 2, 3, 4, 5).forEach labelQueEuQuiser@{
        if (it == 3) return@labelQueEuQuiser    // TODO local return to the caller of the lambda
        print(it)
    }
    println(" done with explicit label")
}


private fun ex2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach             //TODO local return to the forEach loop
        print(it)
    }
    println(" done with implicit label")
}


private fun ex3() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return          //TODO local return to the caller of the anonymous fun, i.e. the forEach loop
        print(value)
    })
    println(" done with anonymous function")
}


private fun ex4() {
    listOf(1, 2, 3, 4, 5).map {
        if (it == 3) return@map "" else return@map it.toString()
    }.map { print(it) }
    println(" done returning value with implicit label ")

    listOf(1, 2, 3, 4, 5).filter { it != 3 }.map(::print)   //TODO esse seria o jeito mais legível
    println(" O jeito ")
}




