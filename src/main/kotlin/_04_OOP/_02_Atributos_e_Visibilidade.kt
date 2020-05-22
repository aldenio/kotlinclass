package _04_OOP

import util.execute


fun main() {
    execute(::ex1,::ex2,::ex3,::ex4)
}



private fun ex1() {
    val address = VisibilityTypes()
    address.b = "Other"
    println(address.b)
}
open class VisibilityTypes {
    var a: String = "a"
    internal var b = "b"
    protected var c = "c"
    private var d: String? = null
    open var e: String = "123456"
    val readOnly: Boolean = true
}




private fun ex2(){
    class AnnotatedProperty {
        var name:String = "name"
            private set                                         //TODO alteração da visibilidade do get

        val isNameEmpty get() = name.length == 0                //TODO get na mesma linha

        @Transient var age:Int = 0                              //TODO anotação da propriedade

        var sobrenome:String= ""
            @java.lang.SuppressWarnings get                         //TODO anotações no método get
    }
    println(AnnotatedProperty().name)
}





private fun ex3(){
    class LateInitProperty{
        lateinit var xpto: String                              //TODO lateinit
        override fun toString(): String = if (::xpto.isInitialized) xpto else "<vazio>"     //TODO isInitialized
    }
    val lateInitProperty = LateInitProperty()
    println(lateInitProperty)
}





private fun ex4() {
    class GetSet {
        /**
         * A palavra 'field' é palavra-reservada dentro do escopo dos métodos get e set.
         */
        var primeiro: String = "valor inicial"
            set(value) = if (value.isNotEmpty()) field = value else field ="<vazio>"//.also { println("setPrimeiro($value)") }
            get() = "primeiro=$field"//.also { println("getPrimeiro()=$field") }

        /**
         * Segunda propriedade
         */
        var segundo: String = "valor inicial"
            get() {
                println("getSegundo() = $field")
                return "segundo=$field"
            }
            set(value) {
                println("setSegundo($value)")
                field = if (value.isNotEmpty()) value else "<vazio>"                            // if é uma expressão
            }

        override fun toString(): String {
            return "Atributos($primeiro,$segundo)"
        }
    }
    val a = GetSet()
    println(a)
    a.primeiro = ""
    println(a)
    a.segundo = "novo valor"
    println(a)
}




