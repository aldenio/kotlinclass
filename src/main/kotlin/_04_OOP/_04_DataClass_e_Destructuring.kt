package _04_OOP

import util.execute


fun main() {
    execute(::ex1,::ex2,::ex3)
}

/**
 * Data class e métodos
 */
private fun ex1() {
    var p1 = DataClass()
    println(p1)

    println("Hashcode == ${p1.hashCode()}")

    var p2 = DataClass()
    println("$p1 é igual a $p2? ${p1 == p2}.")

    var p3 = p1.copy()
    println("$p1 é igual a $p3? ${p1 == p3}.")

    var p4 = p1.copy(nome = "Cicrano")                  //TODO o método copy pode receber argumentos
    println("$p1 é igual a $p4? ${p1 == p4}.")
}
data class DataClass(var nome: String = "Fulano", val sobrenome: String = "Silva", val idade: Int = 32)


/**
 * Desestruturação
 */
private fun ex2(){
    val um = DataClass()
    val (name, surname, age) = um
    println("nome=$name, sobrenome=$surname, idade=$age")
    val (nome,_,_) = um
    println("o nome é $nome, o resto não me interessa!")
}


/**
 * Data classes fornecidos Pair e Triple
 */
private fun ex3(){
    val pair:Pair<String, Int> = "um".to(1)
    println(pair)
    val triple = Triple("a", 3, true)
    println(triple)
}
