package _03_FP

import java.math.BigInteger


fun main() {
    println("somaRecursiva(150_000) = ${somaRecursiva(1_500_000)}")                 //TODO: sugar syntax: '_'
}


/**
 * To be eligible for the tailrec modifier, a function must call itself as the last operation it performs.
 * You cannot use tail recursion when there is more code after the recursive call, and you cannot use it within try/catch/finally blocks.
 * Currently, tail recursion is supported by Kotlin for JVM and Kotlin/Native.
 */
tailrec fun somaRecursiva(i: Int, acc: BigInteger = BigInteger.ZERO): BigInteger {      //TODO: tailrec function
  return if (i <= 0) acc else somaRecursiva(i - 1, acc.add(i.toBigInteger()))
}


/**
 * Using higher-order functions imposes certain runtime penalties: each function is an object, and it captures a closure,
 * i.e. those variables that are accessed in the body of the function. Memory allocations (both for function objects and
 * classes) and virtual calls introduce runtime overhead.
 * But it appears that in many cases this kind of overhead can be eliminated by inlining the lambda expressions.
 * The inline modifier affects both the function itself and the lambdas passed to it: all of those will be inlined into the call site.
 * TODO: ver noinline e crossinline
 */
inline fun somaInline(a:Int, b: Int): Int = a + b         //TODO: inline function

