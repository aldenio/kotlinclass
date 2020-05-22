package _06_DSL

import util.execute
import kotlin.math.abs

fun main() {
    execute(::ex1, ::ex2,::ex3,::ex4,::ex5,::ex6,::ex7, ::ex8,::ex9,::ex10,::ex11,::ex12,::ex13, ::ex14,::ex15,::ex16,::ex17,::ex18,::ex19)
}

data class Point(var x: Int, var y: Int) {
    override fun equals(other: Any?): Boolean = other is Point && other.x == this.x && other.y == this.y
    operator fun unaryPlus() = Point(abs(x), abs(y))
    operator fun unaryMinus() = Point(-abs(x), -abs(y))
    operator fun inc() = Point(x + 1, y + 1)
    operator fun dec() = Point(x - 1, y - 1)
    operator fun not() = Point(-x, -y)
    operator fun plus(b: Point) = Point(x + b.x, y + b.y)
    operator fun minus(b: Point) = Point(x - b.x, y - b.y)
    operator fun times(b: Point) = Point(x * b.x, y * b.y)
    operator fun div(b: Point) = Point(x / b.x, y / b.y)
    operator fun rem(b: Point) = Point(x % b.x, y % b.y)
    operator fun invoke(): Unit = println("Eu sou um ponto!")
    operator fun plusAssign(b: Point) = Unit.also { this.x += b.x; this.y += b.y }
    operator fun minusAssign(b: Point) = Unit.also { this.x -= b.x; this.y -= b.y }
    operator fun timesAssign(b: Point) = Unit.also { this.x *= b.x; this.y *= b.y }
    operator fun divAssign(b: Point) = Unit.also { this.x /= b.x; this.y /= b.y }
    operator fun remAssign(b: Point) = Unit.also { this.x %= b.x; this.y %= b.y }
    operator fun rangeTo(b: Point): Line = Line(this, b)
    operator fun compareTo(b: Point): Int = (abs(x) + abs(y)).compareTo(abs(b.x) + abs(b.y))
}

data class Line(var p1: Point, var p2: Point)

operator fun Line.contains(p: Point): Boolean {
    val a = (this.p2 - this.p1)
    val b = p - this.p2
    return (a.x as Double / a.y as Double) == (b.x as Double / b.y as Double)
}

operator fun Line.get(i: Int): Point = when (i) {
    0 -> this.p1
    1 -> this.p2
    else -> throw ArrayIndexOutOfBoundsException()
}

operator fun Line.set(i: Int, p:Point): Unit = when (i) {
    0 -> this.p1 = p
    1 -> this.p2 = p
    else -> throw ArrayIndexOutOfBoundsException()
}


/**
 * UnaryPlus (+it)
 */
private fun ex1() {
    val point = Point(-10, 20)
    println(+point)
}

/**
 * UnaryMinus (-it)
 */
private fun ex2() {
    val point = Point(-10, 20)
    println(-point)
}

/**
 * not (!it)
 */
private fun ex3() {
    val point = Point(-10, 20)
    println(!point)
}

/**
 * inc (it++)
 */
private fun ex4() {
    var point = Point(-10, 20)
    point++
    println(++point)
}

/**
 * dec (it--)
 */
private fun ex5() {
    var point = Point(-10, 20)
    point--
    println(--point)
}


/**
 * plus (it_1 + it_2)
 */
private fun ex6() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1 + p2)
}

/**
 * minus (it_1 - it_2)
 */
private fun ex7() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1 - p2)
}

/**
 * times (it_1 * it_2)
 */
private fun ex8() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1 * p2)
}

/**
 * div (it_1 / it_2)
 */
private fun ex9() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1 / p2)
}

/**
 * rem (it_1 / it_2)
 */
private fun ex10() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1 % p2)
}


/**
 * plusAssign (it_1 += it_2)
 *         or (it_1 =+ it_2)
 */
private fun ex11() {
    val p1 = Point(-10, 20)             //TODO trocar val por var nessa linha.
    var p2 = Point(10, -20)
    p1 += p2
    println(p1)
}

/**
 * minusAssign (it_1 -= it_2)
 *          or (it_1 =- it_2)
 */
private fun ex12() {
    val p1 = Point(-10, 20)             //TODO trocar val por var nessa linha.
    var p2 = Point(10, -20)
    p1 -= p2
    println(p1)
}

/**
 * timesAssign (it_1 *= it_2)
 *          or (it_1 =* it_2)
 */
private fun ex13() {
    val p1 = Point(-10, 20)             //TODO trocar val por var nessa linha.
    var p2 = Point(10, -20)
    p1 *= p2
    println(p1)
}

/**
 * divAssign (it_1 /= it_2)
 *        or (it_1 =/ it_2)
 */
private fun ex14() {
    val p1 = Point(-10, 20)             //TODO trocar val por var nessa linha.
    var p2 = Point(10, -20)
    p1 /= p2
    println(p1)
}

/**
 * remAssign (it_1 %= it_2)
 *        or (it_1 =% it_2)
 */
private fun ex15() {
    val p1 = Point(-10, 20)             //TODO trocar val por var nessa linha.
    var p2 = Point(10, -20)
    p1 %= p2
    println(p1)
}

/**
 * rangeTo (it_1..it_2)
 */
private fun ex16() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1..p2)
}

/**
 * contains (it_1 in it_2)
 *       or (it_1 !in it_2)
 */
private fun ex17() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    println(p1 in p1..p2)
    println(p1 !in p1..p2)
}

/**
 * get (it[i])
 * set (it[i] = x)
 */
private fun ex18() {
    var p1 = Point(-10, 20)
    var p2 = Point(10, -20)
    val line = p1..p2
    println(line[0])
    line[1] = Point(0,0)
    println(line)
}

/**
 * invoke (it())
 */
private fun ex19() {
    var p1 = Point(-10, 20)
    p1()
}
