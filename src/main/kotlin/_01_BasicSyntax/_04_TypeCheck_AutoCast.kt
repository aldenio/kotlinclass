package _01_BasicSyntax

fun main() {
    println(getStringLength1("xpto"))
    println(getStringLength2("xpto"))
    println(getStringLength3("xpto"))

    println(getStringLength1(32))
    println(getStringLength2(1.25))
    println(getStringLength3(true))
}

fun getStringLength1(obj: Any): Int {
    if (obj is String) {
        return obj.length                   // TODO `obj` is automatically cast to `String` in this branch
    }
    return 0                             // TODO `obj` is still of type `Any` outside of the type-checked branch
}

fun getStringLength2(obj: Any): Int {
    if (obj !is String) return 0
    return obj.length                       // TODO `obj` is automatically cast to `String` in this branch
}


fun getStringLength3(obj: Any): Int {
    if (obj is String && obj.length > 0) {  // TODO `obj` is automatically cast to `String` on the right-hand side of `&&`
        return obj.length
    }
    return 0
}
