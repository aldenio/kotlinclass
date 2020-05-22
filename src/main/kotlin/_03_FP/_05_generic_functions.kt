package _03_FP

import util.execute
import java.math.BigDecimal
import java.math.BigInteger
import javax.swing.tree.DefaultMutableTreeNode
import javax.swing.tree.TreeNode

fun main() {
    execute(::ex1,::ex2,::ex3,::ex4,::ex5)
}

private fun ex1() {
    fun <T : Number> somaGenerica(a: T, b: T): T {                         //TODO: generic function
        val result = when (a) {
            is Int -> a + (b as Int)                                        //TODO is == instanceof
            is Double -> a + (b as Double)
            is Byte -> a + (b as Byte)
            is Float -> a + (b as Float)
            is Long -> a + (b as Long)
            is Short -> a + (b as Short)
            is BigDecimal -> a + (b as BigDecimal)
            is BigInteger -> a + (b as BigInteger)
            else -> throw IllegalArgumentException("tipo desconhecido")
        }
        return result as T                                                  //TODO as == (cast)
    }

    println("somaGenerica(1.23, 1.45) = ${somaGenerica(1.23, 1.45)}")
}

/**
 * Normal functions (not marked as inline) cannot have reified parameters. A type that does not have a run-time
 * representation (e.g. a non-reified type parameter or a fictitious type like Nothing) cannot be used as an argument
 * for a reified type parameter.
 */
private fun ex2() {
    fun <T> TreeNode.getParentAsT(clazz: Class<T>): T? = parent as T?

    val treeNode = DefaultMutableTreeNode()
    treeNode.getParentAsT(Integer::class.java)                          //TODO: versao normal
    treeNode.getParentAsT<Integer>()                                    //TODO versão reificada
}
private inline fun <reified T> TreeNode.getParentAsT(): T? = parent as T?  // TODO: reified type parameter


private fun ex3(){
//    fun <T> foo(value:Any):Boolean = value is T       //TODO descomentar e ver o erro.
    println("\"\" é uma string? ${foo<String>("")}")
}
inline fun <reified T> foo(value:Any):Boolean = value is T


private fun ex4() {
    open class Animais
    open class Mamiferos : Animais()
    open class Humanos : Mamiferos()

    fun <T : Mamiferos> copy(from: Array<out T>, to: Array<in T>) {         //TODO: Type projections
        assert(from.size == to.size)
        for (i in from.indices) {
            to[i] = from[i]
        }
    }

    val animais = Array(3) { Animais() }
    val mamiferos = Array(3) { Mamiferos() }
    val humanos = Array(3) { Humanos() }
    val listaOut = listOf(humanos, mamiferos)                           //TODO: a inferencia padrão usa out, veja o tipo de listaOut
    val listaIn  = listOf<Array<in Mamiferos>>(animais, mamiferos)

    for( a in listaOut) {
        for (b in listaIn) {
            copy(a, b)
        }
    }
}


private fun ex5() {
    fun sizeOf(arr: Array<*>) = arr.size
    val arr = Array<Unit>(3){ Unit }                            //TODO um array de "void"
    println("the size of void array is = ${sizeOf(arr)}")
}



