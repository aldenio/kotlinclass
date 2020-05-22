package _03_FP

import util.execute

fun main() {
    execute(::ex1,::ex2,::ex3, ::ex4, ::ex5, ::ex6, ::ex7, ::ex8)
}

/**
 * Declaração, tipo e uso separados de lambda
 */
private fun ex1() {
    fun calculadoraTripla(a: Int, b: Int, c: Int, operation: (Int, Int, Int) -> Int): Int = operation(a, b, c)
    val somaTripla: (Int, Int, Int) -> Int = { a, b, c -> a + b + c }                //TODO lambda long syntax
    val adicao = calculadoraTripla(1, 1, 1, somaTripla)
    println("adicao 1+1+1 = $adicao")
}

/**
 * lambda expressions
 */
private fun ex2() {
    fun calculadoraDupla(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)
    val subtracao = calculadoraDupla(1, 1, { a, b -> a - b })                        // TODO lambda short syntax
    println("subtracao 1-1 = $subtracao")
}

/**
 * Sugar syntax para lambdas (trailling lambdas)
 * e parâmetro implícito "it"
 */
private fun ex3() {
    fun calculadoraSimples(a: Int, operation: (Int) -> Int): Int = operation(a)
    val aoQuadrado = calculadoraSimples(2)  { it * it }                              //TODO: sugar syntax: {} fora do ()
    val imprime: (Any) -> Unit = { println(" 2 elevado ao quadrado é $it") }        //TODO: sugar syntax: variável automática it
    imprime(aoQuadrado)
}

/**
 * Detalhe do sugar syntax
 */
private fun ex4() {
    fun calculadora(operation: (Int, Int) -> Int, a: Int, b: Int): Int = operation(a, b)
    //    val erro = calculadora2(a=1, b=1) { a, b -> a * b }             //TODO: sugar syntax: só funciona quando o lambda é o ultimo parâmetro.
}

/**
 * Lambda sem parâmetros e ponteiros para funções.
 */
private fun ex5() {
    fun rodaPrintHello(hello: () -> Unit) = hello()                       //TODO syntax de lambda sem parâmetro.
    val valPrintHello: () -> Unit = { println("Hello World") }

    rodaPrintHello(valPrintHello)
    rodaPrintHello(::printHello)
}
private fun printHello() { println("Hello World privado") }


/**
 * Sugar syntax quando o lambda é o único parametro
 */
private fun ex6() {
    var pessoa = Pessoa("Fulano")

    pessoa.create { println("$it foi criado!") }
}



/**
 * Lambda x SAM
 */
private fun ex7() {
    var pessoa = Pessoa("Beltrano")

    var eventListener = { p: Pessoa -> println("$p foi criado!") }
    pessoa.create(eventListener)

    var eventListener2 = Created { println("$it foi criado!") }
    pessoa.create(eventListener2)
}

/**
 * Anonimous functions
 */
private fun ex8(){
    val func = fun():String? { return null }
    println(func())
}

