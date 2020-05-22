package _02_BasicSyntax

import _03_FP.Endereco
import _03_FP.Pessoa
import util.execute


@Suppress("DuplicatedCode")
fun main() {
    execute(::ex1,::ex2,::ex3,::ex4,::ex5,::ex6,::ex7)
}

private fun ex1() {
    fun imprime(texto: String?) {                           //TODO note a ? no fim do tipo String
        println("$texto tem ${texto?.length ?: "nenhum"} caracteres.")
    }

    imprime("e")
    imprime(null)
}



private fun ex2() {
    var s1: String = "s1"
    var s2: String? = "s2"
    var s3: String? = null
//    s1 = s2                                               //TODO não pode atribuir nullable para não nullable
    s2 = s1

    println("s3.toUpperCase() = ${s3?.toUpperCase()?.toLowerCase()?.toInt()}")          //TODO safe access
    val s4 = s3 ?: "s3 estava nulo"                             //TODO: Elvis
    println("s4 == $s4")

}


private fun ex3() {
    fun printNumber(obj: Any?) {
        val number = obj as? Number                             //TODO safe cast
        println(number)
    }
    printNumber("")
    printNumber(2)
    printNumber(null)
}


private fun ex4() {
    fun getS6(): String? = "s6"
    val s6: String? = getS6()!!                                //TODO bang-bang (not null assertion)
    println("s6 == ${s6!!.toUpperCase()}")                      //TODO bang-bang (not null assertion)
}


private fun ex5() {
    fun validaMapa(map: Map<String, Int?>) {
        val a = map["a"] ?: throw IllegalArgumentException("a is missing!")
        println("a=$a")
    }

    val map: Map<String, Int?> = mapOf("a" to 1, "b" to 2, "c" to 3, "e" to null)
    validaMapa(map)
}

private fun ex6() {
    fun pow(i: Int) = i * i
    var n: Int? = 30

    //pow(n)                                //TODO o compilador não aceita, Int e Int? são tipos diferentes

    n?.let { println(pow(n)) }              //TODO função let + smartcast resolve!
}


private fun ex7() {
    var p = Pessoa("nome")
//    val sobrenome: String = p.sobrenome   //TODO olhar a implementação do get e set de sobrenome na classe Pessoa ...
//    p.setSobrenome(null)                  //TODO ... depois descomentar essas linhas.
    p.setSobrenome("sobrenome")
    println(p)
}


/**
 * Platform types, nullable types and not nullable types.
 */
private fun ex8() {
    //TODO observe o tipo (String!) do método getRua na interface Endereco.
    class EnderecoProfissional : Endereco {
        override fun getRua(): String = ""
    }

    class EnderecoResidencial : Endereco {
        override fun getRua(): String? = null
    }
}
