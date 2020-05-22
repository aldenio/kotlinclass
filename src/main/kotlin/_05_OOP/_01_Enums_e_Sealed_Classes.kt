package _05_OOP

import util.execute
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator


fun main() {
    execute(::ex1,::ex2,::ex3,::ex4,::ex5)
}

/**
 * Enumerações simples
 */
private fun ex1() {
    fun printAllValues() {
        println(Direction.values().joinToString { it.name })
    }
    printAllValues()
}
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}



/**
 * Enumerações com atributos
 */
private fun ex2(){
    fun print(){
        println(enumValues<Color>().joinToString { it.ordinal.toString() })
    }
    print()
}
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}


/**
 * Enumerations com implementações e funções
 */
private fun ex3(){
    fun print(){
        println(enumValues<ProtocolState>().joinToString { it.signal().name })
    }
    print()
}
enum class ProtocolState {
    WAITING {                                   //TODO anonymous classes
        override fun signal() = TALKING
        fun funcaoQualquer() {}
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

/**
 * Enumerations implementando interfaces.
 */
private fun ex4(){
    fun print(){
        println(IntArithmetics.valueOf("PLUS"))
    }
    print()
}
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {  // TODO implement interfaces
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}

/**
 * Sealed classes
 */
private fun ex5(){
    val countries: List<CardinalPoints> = listOf(South("Brasil"),South("Argentina"))
    for (c in countries) {
        when (c) {
            is North -> TODO()
            is East -> TODO()
            is West -> TODO()
            is South -> println(c.country)
            else -> println(NoWhere)
        }
    }
}
sealed class CardinalPoints
class North : CardinalPoints()
class East : CardinalPoints()
class West : CardinalPoints()
data class South(var country:String) : CardinalPoints()
object NoWhere : CardinalPoints()
