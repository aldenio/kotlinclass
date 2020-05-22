package _06_DSL

/**
 * Faça uma calculadora de Pontos e Linhas.
 * Ex: p12,11 + p10,50
 * Ex: l0,0,10,10 + l5,5,8,3
 *
 * ou
 *
 * Escreva uma DSL para construir polígonos baseados em Line e Point.
 * Siga o exemplo abaixo!
 */
fun main(args: Array<String>) {
    val person = person {
        name = "John"
        age = 25
        address {
            street = "Main Street"
            number = 42
            city = "London"
        }
    }
}

data class Person(var name: String? = null,
                  var age: Int? = null,
                  var address: Address? = null)

data class Address(var street: String? = null,
                   var number: Int? = null,
                   var city: String? = null)

fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.address(block: Address.() -> Unit) {
    address = Address().apply(block)
}
