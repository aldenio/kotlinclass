package _01_BasicSyntax


fun main() {                                             // TODO: A função main nem precisa dos parâmetros.
    println("soma1(2, 2) = ${soma1(2, 2)}")

    println("soma2(2, 2) = ${soma2(2, 2)}")

    println("soma3(1) = ${soma3(1)}")

    println("soma4(1,2) = ${soma4(1, 2)}")

    println("somaTodos(1, 2, 3, 4) = ${somaTodos(1, 2, 3, 4)}")

    printSum1(1, 1)

    printSum2(b = 2, a = 1)                             //TODO: named arguments
}


fun soma1(a: Int, b: Int): Int {                        //TODO: regular function
    return a + b
}

fun soma2(a: Int, b: Int) = a + b                       //TODO: single expression function


fun soma3(a: Int = 0, b: Int = 0) = a + b               //TODO: default argument


fun soma4(a: Int = 0, b: Int = 0): Int {
    fun soma2(c: Int, d: Int) = c + d + 4               //TODO: local functions
    return soma2(a, b)
}


fun somaTodos(vararg valores: Int) {                    //TODO: vararg == ...
    valores.reduce(Int::plus)
}


fun printSum1(a: Int, b: Int): Unit {                   //TODO: O tipo Unit equivale ao void do java.
    println("printSum1 of $a + $b = ${a + b}")
}


fun printSum2(a: Int, b: Int) {                         //TODO: Quando o retorno for Unit, ele pode ser omitido.
    println("printSum2 of $a + $b = ${a + b}")
}

