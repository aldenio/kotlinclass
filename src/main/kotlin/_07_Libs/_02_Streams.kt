package _07_Libs

import util.execute

fun main() {
    execute(::ex1,::ex2,::ex3)
}

/**
 * sequence == streams in java
 */
private fun ex1() {
    data class Pessoa (val nome: String)
    val pessoas = listOf(Pessoa("Jose"), Pessoa("Maria"), Pessoa("Joao"), Pessoa("Joana"))
    val nomes = pessoas
                       .asSequence()         //TODO: comente essa linha e veja o resultado
                       .filter { println("filter($it)"); it.nome.startsWith("J") }
                       .map { println("map($it)"); it.nome }
    nomes.forEach { println(it) }
}


/**
 * Terminal & non terminal operations
 */
private fun ex2() {
    data class Pessoa (val nome: String)
    val pessoas = listOf(Pessoa("Jose ..."), Pessoa("Maria"), Pessoa("Joao"), Pessoa("Joana"))
    val nome = pessoas
        .asSequence()               //TODO: comente essa linha e veja o resultado
        .map { println("map($it)"); it.nome.toUpperCase() }
        .find { it.startsWith("JOSE") }
    println(nome)
}



/**
 * Terminal & non terminal operations
 */
private fun ex3() {
    fun printIt(seq:Sequence<String>){
        seq.forEach { println(it) }
    }

    data class Pessoa (val nome: String)
    val pessoas = listOf(Pessoa("Jose ..."), Pessoa("Maria"), Pessoa("Joao"), Pessoa("Joana"))
    val seqPessoas = pessoas.asSequence()
    printIt(seqPessoas.map { println("map($it)"); it.nome.toUpperCase() })

    printIt(seqPessoas.map { println("map($it)"); it.nome.toLowerCase() })
}


