package _06_DSL

import util.execute


fun main() {
    execute(::ex1,::ex2,::ex3,::ex4)
}

/**
 * Extension function
 */
private fun ex1() {
    fun Int.soma(b: Int): Int = this + b                    //TODO: extension function
    println("1.soma(2) = ${1.soma(2)}")
}


/**
 * Infix Extension function
 */
private fun ex2() {
    infix fun Int.somaInfix(b: Int): Int = this + b         //TODO: infix extension function

    println("1 somaInfix 2 = ${1 somaInfix 2}")
}


/**
 * Extensions are resolved statically!
 *
 * Extensions do not actually modify classes they extend. By defining an extension, you do not insert new members into
 * a class, but merely make new functions callable with the dot-notation on variables of this type.
 */
private fun ex3() {
    open class Shape
    class Rectangle : Shape()

    fun Shape?.getName() = if (this == null) "null Shape" else "Shape"      //TODO: Nullable Receiver

    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape?) {
        println(s.getName())
    }

    printClassName(Rectangle())
    printClassName(null)
}

/**
 * Extension properties
 */
private fun ex4() {
    val lista = listOf(1, 2, 3)
    println("Lastindex == ${lista.lastIndex}")
}
val <T> List<T>.lastIndex: Int
    get() = size - 1

/**
 * Exercício
 */
//private fun ex5() {
//    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
//        this[index1] = this[index2].also { this[index2] = this[index1] }
//    }
//
//    val list = mutableListOf(1, 2, 3)
//    println(list)
//    list.swap(0, 2)                        //TODO: 'this' inside 'swap()' will hold the value of 'list'
//    println(list)
//}
