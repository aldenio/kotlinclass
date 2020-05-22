package _02_BasicSyntax


fun main() {
    ifExpression(0,1)
    tryExpression("22")

    fun makeAny(): Any = Any()                      // TODO O tipo Any equivale a Object.

    whenExpression(makeAny())
}



/**
 * A instrução try é uma expressão em kotlin e pode ser atribuída a uma variável, ou passada como argumento.
 */
private fun tryExpression(num:String) {
    val c = try {
        num.toInt()
    } catch (ex: NumberFormatException) {
        -1
    }
    println("c é $c")
}


/**
 * Não existe switch em kotlin, no lugar dele, entrou o when.
 */
private fun whenExpression(any: Any) {
    val x = when (any) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }
    println("x is $x")
}


/**
 *  Não existe operador ternário em kotlin "(question)? true: false;", a instrução if é uma expressão.
 */
private fun ifExpression(a:Int, b:Int) {
    val c = if (a > b) a else b
    println("c = $c")
}





