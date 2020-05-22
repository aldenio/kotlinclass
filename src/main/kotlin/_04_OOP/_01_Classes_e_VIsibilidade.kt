package _04_OOP

import util.execute


fun main() {
    println("\n-------------------- 0")
    ex0()

    execute(::ex1, ::ex2, ::ex3, ::ex4, ::ex5, ::ex6, ::ex7, ::ex8, ::ex9, ::ex10, ::ex11, ::ex12)
}




private fun ex0() {
    class Vazia2 {  }                                   //TODO classe válida no escopo da função

    var vazia1 = Vazia1()                               //TODO não existe 'new' em kotlin.
    var vazia2 = Vazia2()
}
class Vazia1



private fun ex1() {
    class Classe1  {                                 //TODO  class == "public final class"
        var nome: String = ""                        //TODO  var nome:String == "private String nome + get + set"
    }

    var p1 = Classe1()
    p1.nome = "p1"
    println("Nome de p1 é ${p1.nome}")
}



private fun ex2() {
    var p2 = Classe2()
    println("Nome de p2 é ${p2.nome}")
}
internal class Classe2() {                      //TODO Construtor primário vazio, dispensável.
    var nome: String = "p2"
}




private fun ex3() {
    class Classe3 {                          //TODO private class == private final class
        var nome: String = "p3"
        constructor() {}                             //TODO construtor alternativo vazio, dispensável.
    }
    var p3 = Classe3()
    println("Nome de p3 é protected")
}



private fun ex4() {
    class Classe4 {
        init {                                          //TODO método inicializador da classe, init.
            /* */
        }
        var nome: String
        init {                                          //TODO método inicializador da classe, init.
            nome = "p4"
        }
    }
    var p4 = Classe4()
    println("Nome de p4 é private")
}



private fun ex5() {
    class Classe5(_nome: String) {             //TODO construtor primário com parâmetros. Sem construtor vazio
        var nome = _nome
    }
    var p5 = Classe5("p6")
    println("Nome de p6 é ${p5.nome}")
}



private fun ex6() {
    class Classe6(var nome: String = "")        //TODO construtor primário com propriedade com valor default.
    var p6 = Classe6("p6")
    println("Nome de p6 é ${p6.nome}")
}



private fun ex7() {
    class Classe7(var nome: String)            //TODO construtor primário com propriedades. Sem construtor vazio

    var p7 = Classe7("p7")
    println("Nome de p7 é ${p7.nome}")
}



private fun ex8() {
    class Classe8(var nome: String) {           //TODO construtor primário com propriedade
        constructor() : this("")                  //TODO construtor secundário vazio
    }
    var p8 = Classe8("p8")
    println("Nome de p8 é ${p8.nome}")
}



private fun ex9() {
    class Classe9() {                           //TODO construtor primário vazio
        var nome: String = ""
        constructor(nome: String) : this() {            //TODO construtor secundário com parâmetro.
            this.nome = nome
        }
    }
    var p9 = Classe9("p9")
    println("Nome de p9 é ${p9.nome}")
}

private fun ex10(){
    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name".also(::println)
        init {
            println("First initializer block that prints ${name}")
        }

        val secondProperty = "Second property: ${name.length}".also(::println)
        init {
            println("Second initializer block that prints ${name.length}")
        }
    }
    InitOrderDemo("InitOrderDemo")
}

private fun ex11(){
    class Constructors {
        constructor() {
            println("Constructor")
        }

        init {
            println("Init block")
        }
    }
    Constructors()
}

private fun ex12(){
    //class ClasseErrada1() {
//    constructor(var nome: String) : this() //TODO Não é permitida a declaração de propriedades no construtor alternativo.
//}

//private class ClasseErrada2() {
//    var nome: String = ""
//    constructor() {}                      //TODO Não é permitida a declaração de dois construtores iguais.
//}
    println("Descomente o código e veja os erros do compilador.")
}
