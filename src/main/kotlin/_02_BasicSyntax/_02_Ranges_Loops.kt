package _02_BasicSyntax

import util.execute
import util.printList

/**
 * Os loops while e do_while são iguais aos do java.
 * O loop for(...;...;...) não existe em kotlin, no lugar dele entrou o for(...in...).
 */
fun main() {
    execute(::ex1, ::ex2, ::ex3, ::ex4, ::ex5, ::ex6)
}

/**
 * Loop sem indice
 */
private fun ex1(){
    fun printList(items: Iterable<Any>) {
        for (item in items) {
            print(item)
        }
    }
    val lista = listOf(1,2,3)
    printList(lista)
}

/**
 * Loop com indice
 */
private fun ex2() {
    fun printListComIndice(items: Collection<Any>) {
        for (indice in items.indices) {
            println("item at $indice is ${(items as List)[indice]}")
        }
    }
    val items = listOf("apple", "banana", "kiwifruit")      // listOf é uma função da lib kotlin
    printListComIndice(items)
}

/**
 * Ranges numéricos
 */
private fun ex3() {
    val range1: IntRange = 1..5               // de 1 a <= 5
    printList(range1)
    val range2 = 1 until 5                      // de 1 a < 5
    printList(range2)
    val range3 = 5 downTo 1                     // de 5 a >= 1
    printList(range3)
}

/**
 * Step
 */
private fun ex4() {
    val range1step: IntProgression = 1..5 step 2              // de 1 a <= 5 de 2 em 2
    printList(range1step)
    val range2step = 1 until 5 step 2         // de 1 a < 5 de 2 em 2
    printList(range2step)
    val range3step = 5 downTo 1 step 3        // de 5 a >= 1 de 3 em 3
    printList(range3step)
}

/**
 * Ranges não numéricos
 */
private fun ex5() {
    val range4: CharRange = 'a'..'z'
    printList(range4)
    val range5 = 'A'..'Z'
    printList(range5)
}

/**
 * Como por label no loops, serve pra break e continue.
 */
private fun ex6() {
    loopExterno@ for (i in 0..9) {
        loopInterno@ for (j in 0..9) {
            if (j == 9) {
                break@loopExterno
            }
            print(j)
        }
    }
}






