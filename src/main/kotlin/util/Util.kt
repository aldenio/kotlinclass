package util

import java.util.*

fun execute(vararg exs: () -> Unit): Unit {
    exs.forEachIndexed { i, f -> println("\n--------------------  ${i + 1}"); f() }
    println("\n\n------- fim ---------")
}

fun printList(items: Iterable<Any>) {
    for (item in items) {
        print(item)
    }
    print('\n')
}

val scan = Scanner(System.`in`)
fun next(): String? = if (Random().nextBoolean()) scan.next() else null


