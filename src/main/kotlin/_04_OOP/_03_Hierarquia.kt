package _04_OOP

import util.execute
import kotlin.math.pow

fun main() {
    execute(::ex1,::ex2,::ex3,::ex4)
}

/**
 * Method overriding and primary constructor call.
 */
private fun ex1() {
    open class Shape(var area: Double) {
        open fun draw(): Unit = TODO()
        fun fill(): Unit = TODO()
    }

    class Circle(raio: Double): Shape(Math.PI * raio.pow(2.0)) {
        override fun draw() = TODO()
    }

    println("A area do círculo de raio 1 = ${Circle(1.0).area}")
}


/**
 * Second constructor,super keyword and property override
 */
private fun ex2(){
    open class Shape(open var area: Double, open val color: String="White")

    class Circle : Shape {
        override var area =-1.0
        override val color ="Black"
        constructor(raio: Double): super(Math.PI * raio.pow(2.0)) { /**/ }
    }
    val c = Circle(1.0)
    println("O circulo novo tem área=${c.area} e cor=${c.color}")
}


/**
 * Multiple inheritance
 */
private fun ex3(){
    open class Rectangle {
        open fun draw() { println("Rectangle.draw()") }
    }
    class Square() : Rectangle(), Polygon {
        override fun draw() {
            super<Rectangle>.draw()
            super<Polygon>.draw()
        }
    }
    // execute
    Square().draw()
}
interface Polygon {
    fun draw() { println("Polygon.draw()") } //TODO interface members are 'open' by default
}

/**
 * Acesso ao pai da classe externa pelo "super@"
 */
private fun ex4(){
    open class Pai  {
        open fun print() { println("Pai.print()") }
        open val name = "pai"
    }
    open class PaiDaClasseInterna {
        open fun print() { println("PaiDaClasseInterna.print()") }
        open val name ="PaiDaClasseInterna"
    }
    class Filha: Pai() {
        override fun print() { println("Filha.print()") ; FilhaInterna().print() }
        override val name = "Filha"

        inner class FilhaInterna : PaiDaClasseInterna() {
            override fun print() {
                super@Filha.print()
                println("print ${super@Filha.name}")
            }
        }
    }
    //
    Filha().print()
}
