package _07_Libs

import util.execute

@kotlin.ExperimentalStdlibApi                               //TODO: marcado como experimental devido ao ex3
fun main() {
    execute(::ex1,::ex2,::ex3,::ex4,::ex5,::ex6)
}

/**
 * Foreach, also, filter, map
 */
private fun ex1() {
    val ints = listOf(1, 2, 3, 4, 5)
    ints.forEach(::print).also { println("") }


    val smallInts = ints.filter { it < 4 }
    println(smallInts)

    val squaredInts = ints.map { it * it }
    println(squaredInts)

    val smallSquaredInts = ints.filter { it < 4 }.map { it * it }
    println(smallSquaredInts)
}

/**
 * map projections
 */
private fun ex2() {
    data class Reuniao(var titulo: String = "titulo")

    val reunioes = listOf(Reuniao(), Reuniao())
    val titulos = reunioes.map { it.titulo }

    titulos.forEach { print("$it, ") }.also { println("") }
}



/**
 * reduce, reduceRight, fold e foldRight
 */

private fun ex3() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val soma1 = numbers.reduce(Int::plus)
    val soma2 = numbers.reduce { sum, element -> sum + element }
    val soma3 = numbers.fold(0) { sum, element -> sum + element }
    println("soma1=$soma1, soma2=$soma2, soma3=$soma3")


    val numerais = listOf("1","2","3","4","5")
    val reduce = numerais.reduce { acc, s -> println("s=$s, acc=$acc"); s + acc }
    val reduceRight = numerais.reduceRight { s, acc -> println("s=$s, acc=$acc"); s + acc }
    println("reduce=$reduce")
    println("reduceRight=$reduceRight")
}

/**
 * all, any, count, find
 */
private fun ex4() {
    val ints = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("$ints > 5")
    val todos: Boolean = ints.all { it > 5 }.also { println("all = $it") }
    val algum: Boolean = ints.any { it > 5 }.also { println("any = $it") }
    val quantos: Int = ints.count { it > 5 }.also { println("count = $it") }
    val achou: Int? = ints.find { it > 5 }.also { println("find = $it") }


    ints.findLast { it > 5 }.also { println("findLast = $it") }
    ints.last().also { println("last = $it") }
    ints.first().also { println("first = $it") }
}


/**
 * min, max, sum, average e count
 */
private fun ex5(){
    val numbers = listOf(6, 42, 10, 4)

    println("Count: ${numbers.count()}")
    println("Max: ${numbers.max()}")
    println("Min: ${numbers.min()}")
    println("Average: ${numbers.average()}")
    println("Sum: ${numbers.sum()}")
}


/**
 * minBy, maxBy, minWith e maxWith
 */
private fun ex6(){
    val numbers = listOf(5, 42, 10, 4)
    val min3Remainder = numbers.minBy { it % 3 }
    println(min3Remainder)

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWith(compareBy { it.length })
    println(longestString)
}



/**
 * scan (experimental), scanReduce (experimental)
 */
@kotlin.ExperimentalStdlibApi               //TODO: marcado como experimental devido aos métodos scan e scanReduce.
private fun ex7(){
    val valores = listOf("1", "2", "3", "4", "5")
    println(valores.scan("", String::plus))
    println(valores.scanReduce(String::plus))
}
