package _01_BasicSyntax

/**
 * 'val' indica uma constante em java seria final.
 * 'var' indica uma variável, tal qual o 'var' do java.
 */
fun main() {
    val a: Int = 1
    println("a é $a do tipo ${a.javaClass}")
    imprime("a", a)

    val b = 2                   // `Int` type is inferred
    imprime("b", b)

    val c: Int                  // Type required when no initializer is provided
    c = 3                       // deferred assignment
    imprime("c", c)

    val d: String = "D"
    imprime("d", d)

    val e= Unit
    imprime("e", e)

    val f = Any()
    imprime("f", f)

    val h = 1_000_000           // TODO syntax sugar para facilitar a leitura de numeros grandes.
    imprime("h", h)

    val i = 1.0
    imprime("i", i)

    //fail("Nothing")           //TODO descomentar
}

fun imprime(nome: String, valor: Int) {                         //TODO Comente este método e rode novamente.
    println("$nome é $valor do tipo ${valor.javaClass}")
}

fun imprime(nome: String, valor: Any) {
    println("$nome é $valor do tipo ${valor.javaClass}")
}

fun fail(message: String): Nothing {                            //TODO Observe o tipo do retorno desse método.
    throw IllegalArgumentException(message)
}
