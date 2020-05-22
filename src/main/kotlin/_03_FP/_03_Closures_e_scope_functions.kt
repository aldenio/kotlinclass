package _03_FP

import util.execute
import java.time.LocalDateTime

fun main() {
    execute(::ex1, ::ex2, ::ex3, ::ex4, ::ex5, ::ex6, ::ex7)
}

data class Reuniao(
    var titulo: String = "",
    var data: LocalDateTime? = null,
    var participantes: MutableList<String>? = null
)


/**
 * Closures
 */
private fun ex1() {
    var pessoa = Pessoa("Cicrano")

    var count = 0

    pessoa.create { println("$it foi criado ${++count} vezes!") }
    pessoa.create { println("$it foi criado ${++count} vezes!") }
    println(count)
}


/**
 * With
 */
private fun ex2() {
    val r1 = Reuniao()
    with(r1) {                                                   //TODO: with
        titulo = "Aula de kotlin"
        data = LocalDateTime.of(2020, 5, 20, 20, 16, 30)
        participantes = mutableListOf("fulano", "cicrano", "beltrano")
    }
    println(r1)
}

/**
 * Apply
 */
private fun ex3() {
    val r = Reuniao()
    var r2 = r.apply {
        this.titulo = "Aula 2 de kotlin"
        this.data = LocalDateTime.of(2020, 6, 20, 20, 16, 30)
        this.participantes = mutableListOf("fulano", "cicrano", "beltrano")
        "fim"
    }
    println(r2)
}

/**
 * also
 */
private fun ex4() {
    val r = Reuniao()
    val r2 = r.also {
        it.titulo = "Aula 2 de kotlin"
        it.data = LocalDateTime.of(2020, 6, 20, 20, 16, 30)
        it.participantes = mutableListOf("fulano", "cicrano", "beltrano")
        "fim"
    }
    println(r2)
}

/**
 * let
 */
private fun ex5() {
    val r = Reuniao()
    val r2 = r.let {
        it.titulo = "Aula 2 de kotlin"
        it.data = LocalDateTime.of(2020, 6, 20, 20, 16, 30)
        it.participantes = mutableListOf("fulano", "cicrano", "beltrano")
        "fim"
    }
    println(r2)
}


/**
 * run com contexto
 */
private fun ex6() {
    val r = Reuniao()
    val r2 = r.run {
        this.titulo = "Aula 2 de kotlin"
        this.data = LocalDateTime.of(2020, 6, 20, 20, 16, 30)
        this.participantes = mutableListOf("fulano", "cicrano", "beltrano")
        "fim"
    }
    println(r2)
}

/**
 * run sem contexto
 */
private fun ex7() {
    val r2 = run {
        println("Esse é o run sem contexto!")
        "fim"
    }
    println(r2)
}
