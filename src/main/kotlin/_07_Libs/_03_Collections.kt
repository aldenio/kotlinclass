package _07_Libs

import util.execute

fun main() {
    execute(::ex1, ::ex2, ::ex3, ::ex4, ::ex5, ::ex6, ::ex7, ::ex8, ::ex9, ::ex10, ::ex11, ::ex12, ::ex13, ::ex14)
}

/**
 * Operadores + e -
 */
private fun ex1() {
    val numbers = listOf("one", "two", "three", "four")

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList)
    println(minusList)
}

/**
 * groupBy
 */
private fun ex2() {
    val numbers = listOf("one", "two", "three", "four", "five")

    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))
}

/**
 * zip
 */
private fun ex3() {
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))

    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color" })
}

/**
 * unzip
 */
private fun ex4() {
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())
}

/**
 * AssociateWith
 */
private fun ex5() {
    val numbers = listOf("one", "two", "two", "three", "four")
    println(numbers.associateWith { it.length })
}

/**
 * AssociateBy
 */
private fun ex6() {
    val numbers = listOf("one", "two", "two", "three", "four")

    println(numbers.associateBy { it.first().toUpperCase() })
    println(numbers.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))
}

/**
 * flatten
 */
private fun ex7() {
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
}

/**
 * flatMap
 */
private fun ex8() {
    data class StringContainer(val values: List<String>)

    val containers = listOf(
        StringContainer(listOf("one", "two", "three")),
        StringContainer(listOf("four", "five", "six")),
        StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap { it.values })
}

/**
 * joinToString
 */
private fun ex9() {
    val numerals = listOf("one", "two", "three", "four")
    println(numerals.joinToString())
    println(numerals.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))
    println(numerals.joinToString { "Element: ${it.toUpperCase()}" })

    val numbers = (1..100).toList()
    println(numbers.joinToString(limit = 10, truncated = "<...>"))
}

/**
 * Take e drop
 */
private fun ex10() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
}

/**
 * takeWhile e dropWhile
 */
private fun ex11() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.takeWhile { !it.startsWith('f') })
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })
}

/**
 * Slice
 */
private fun ex12() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))
}

/**
 * Chunked
 */
private fun ex13() {
    val numbers = (0..13).toList()
    println(numbers.chunked(3))
    println(numbers.chunked(3) { it.sum() })
}

/**
 * Windowed
 */
private fun ex14() {
    val numerals = listOf("one", "two", "three", "four", "five")
    println(numerals.windowed(3))

    val numbers = (1..10).toList()
    println(numbers.windowed(3, step = 3, partialWindows = true))
    println(numbers.windowed(3) { it.sum() })
}

