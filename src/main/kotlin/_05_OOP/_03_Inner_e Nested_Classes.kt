package _05_OOP

import util.execute

fun main() {
    execute(::ex1,::ex2,::ex3,::ex4)
}


private fun ex1(){
    open class A(open val y: String = "A")
    val ab: Any = object : A(), B {
        override val y = "AB"
    }
    val a :A = ab as A
    val b : B = ab as B

    println(a.y)
    println(b)
}
interface B{
    val y: String
}




/**
 * Annonimous inner class, object expression
 */
private fun ex2() {
    fun calculator(a: Int, b: Int, operation: Operation): Int {
        return operation.execute(a, b)
    }
    calculator(1, 1, object : Operation {               //TODO anonymous inner class
        override fun execute(a: Int, b: Int): Int {
            return a + b
        }
    })
}
interface Operation {
    fun execute(a: Int, b: Int): Int
}




/**
 * Nested class
 */
private fun ex3(){
    println(Outer2.Nested().foo())
}
private class Outer2 {
    private val bar: Int = 1
    class Nested {
        private val bar: Int = 2        //TODO comentar essa linha e ver o que acontece
        fun foo() = bar
    }
}






/**
 * Inner class
 */
private fun ex4() {
    println(Outer3().Inner().foo())
}
private class Outer3 {
    private val bar: Int = 1
    inner class Inner {                 //TODO a marcação inner dá acesso à classe de fora.
        fun foo() = bar
    }
}


