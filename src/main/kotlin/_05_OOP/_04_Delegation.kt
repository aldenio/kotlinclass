package _05_OOP

import util.execute
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


fun main() {
    execute(::ex1,::ex2,::ex3,::ex4,::ex5,::ex6,::ex7)
}

/**
 * Implementação por delegação
 */
interface Base1 {
    fun println()
}

private fun ex1() {
    class BaseImpl(val x: Int) : Base1 {
        override fun println() = println(x)
    }

    class Derived(b: Base1) : Base1 by b

    val b = BaseImpl(10)
    Derived(b).println()
}


/**
 * Sobrescrevendo um método implementado por delegação
 */
interface Base2 {
    fun print()
    fun println()
}

private fun ex2() {
    class BaseImpl(val x: Int) : Base2 {
        override fun print() = print(x)
        override fun println() = println(x)
    }

    class Derived(b: Base2) : Base2 by b {
        override fun print() = print("Derived")
    }

    val b = BaseImpl(10)
    Derived(b).print()
    Derived(b).println()
}


/**
 * A classe concreta usada na implementação por delegação não consegue acessar atributos sobrescritos.
 */
private fun ex3() {
    class BaseImpl(val x: Int) : Base3 {
        override val message = "BaseImpl: x = $x"
        override fun print() = print(message)
    }

    class Derived(b: Base3) : Base3 by b {
        override val message =
            "Message of Derived"     // This property is not accessed from b's implementation of `print`
    }

    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
    println(derived.message)
}
interface Base3 {
    val message: String
    fun print()
}






/**
 * Delegação de propriedades
 */
private fun ex4() {
    class Delegate {
        private var value: String = "initial value"
        operator fun getValue(thisref: Any?, property: KProperty<*>): String {
            println("$thisref, thank you for delegating the ${property.visibility} property '${property.name}' to $this!")
            return this.value;
        }

        operator fun setValue(thisref: Any?, property: KProperty<*>, value: String) {
            println("'$value' has been assigned to '${property.name}' in $thisref.")
            this.value = value
        }
    }

    class example {
        var p: String by Delegate()
    }

    val e = example()
    println(e.p)
    e.p = "New value"
}





/**
 * Lazy delegate
 */
private fun ex5() {
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }
    println(lazyValue)
    println(lazyValue)
}





/**
 * Observable delegate
 */
private fun ex6() {
    var name: String by Delegates.observable("<no name>") { prop, old, new -> println("$old -> $new") }
    println(name)
    name = "novo nome"
    println(name)
}





/**
 * Map delegate
 */
private fun ex7() {
    //Read only properties
    val map = mapOf<String, Any?>("nome" to "joão", "idade" to 32)
    val nome: String by map
    val idade: Int by map
    println("nome=$nome")
    println("idade=$idade")

    // read and write properties
    val mutableMap = mutableMapOf<String, Any?>()
    var outroNome: String by mutableMap
    var outraIdade : Int by mutableMap
    outraIdade = 20
    outroNome  = "outro joão"
    println("outraIdade=$outraIdade")
    println("outroNome=$outroNome")
    println(mutableMap)
}


