package _05_OOP

import util.execute
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun main() {
    execute(::ex1, ::ex2, ::ex3, ::ex4, ::ex5, ::ex6, ::ex7, ::ex8)
}


private fun ex1() {
    SingletonManager.register(32)
    println(SingletonManager.allProviders)
}

object SingletonManager {
    val allProviders: MutableCollection<Any> = mutableListOf()

    fun register(provider: Any) {
        allProviders.add(provider)
    }
}

private fun ex2() {
    println("Objects podem extender classes e interfaces normalmente")
}

object DefaultListener : MouseAdapter(), KeyListener {
    override fun mouseClicked(e: MouseEvent) = TODO("método não implementado")
    override fun mouseEntered(e: MouseEvent) = TODO("método não implementado")
    override fun keyTyped(e: KeyEvent?) = TODO("Not yet implemented")
    override fun keyPressed(e: KeyEvent?) = TODO("Not yet implemented")
    override fun keyReleased(e: KeyEvent?) = TODO("Not yet implemented")
}


private fun ex3() {
    val adHoc = object {            //TODO implicit :Any
        var x: Int = 10
        var y: Int = 10
    }
    println(adHoc.x + adHoc.y)
}


private fun ex4() {
    C().bar()
}
class C {
    private fun privateFoo() = object {
        val x: String = "x"
    }

    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        println(privateFoo().x)
        // println(publicFoo().x) //TODO  ERROR: Unresolved reference 'x'
    }
}


/**
 * Companion objects server como o static do java.
 */
private fun ex5() {
    Ex5.print()
}
class Ex5 {
    companion object {
        fun print() = println("Companion Object print méthod")
    }
}

/**
 * Vc pode acesar o companion
 */
private fun ex6() {
    var companion: Ex6.Companion = Ex6.Companion
    companion.print()
}
class Ex6 {
    companion object {
        fun print() = println("Companion Object print méthod")
    }
}


/**
 * Vc pode dar um nome ao companion
 */
private fun ex7() {
    Ex7.print()
    Ex7.Printer.print()
}
class Ex7 {
    companion object Printer {
        fun print() = println("Companion Object print method")
    }
}


/**
 * O companion é um objeto, e como tal pode ter sua propria hierarquia.
 */
private fun ex8() {
    val ex8: Printer = Ex8
    ex8.print()
    val ex8Companion: Printer = Ex8.Companion
    ex8Companion.print()
}

interface Printer {
    fun print(): Unit
}

class Ex8 {
    companion object : Printer {
        override fun print() = println("Companion Object print method")
    }

}

