package _01_BasicSyntax


fun main() {
    val array1: Array<Array<Int>> = arrayOf(arrayOf(1, 2, 3), emptyArray(), arrayOf(4, 5, 6))
    imprime(array1)

    val array2: Array<String?> = arrayOfNulls(3)
    imprime(array2)

    val array3: Array<String> = Array(5) { i -> (i * i).toString() }
    imprime(array3)

    val array4: ByteArray = byteArrayOf(12, 12, 1, 2, 3)
    imprime(array4)

    val array5: IntArray = IntArray(3) { it * 2 }
    imprime(array5)

    println("Strings podem ser lidas como arrays"[1])

    val mapa : MutableMap<Int, String> = mutableMapOf(32 to "Mapas podem ser acessados como arrays")
    mapa[20] = "Mapas podem ser escritos como arrays"
    println(mapa[32])
    println(mapa[20])
}

private fun <T> imprime(arr: Array<T>) {
    println(arr.contentDeepToString())
}

private fun imprime(arr: ByteArray) {
    println(arr.contentToString())
}

private fun imprime(arr: Array<String>) {
    arr.forEach { print("$it, ") }
    println()
}

private fun imprime(arr: IntArray) {
    arr.forEachIndexed { index, i -> print("$index is: $i, ") }
    println()
}
