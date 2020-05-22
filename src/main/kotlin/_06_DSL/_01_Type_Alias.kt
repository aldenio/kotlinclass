package _06_DSL

import java.io.File


fun main() {
    fun foo(p: Predicate<Int>) = p(42)

    val f: (Int) -> Boolean = { it > 0 }
    println(foo(f)) // prints "true"

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p)) // prints "[1]"
}

/**
 * Alias para encurtar tipos longos e genéricos.
 */
typealias StringSet = Set<String>
typealias FileTable<K> = MutableMap<K, MutableList<File>>
/**
 * Alias pra tipos de funções
 */
typealias MyHandler = (Int, String, Any) -> Unit
typealias Predicate<T> = (T) -> Boolean

/**
 * Alias para inner classes.
 */
class A {
    inner class Inner
}
class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner
