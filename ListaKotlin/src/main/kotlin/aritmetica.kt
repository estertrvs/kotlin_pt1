package org.example

fun Int.isPrimo(): Boolean {
    if (this < 2) return false
    for (i in 2 until this) if (this % i == 0) return false
    return true
}

fun mdc(a: Int, b: Int): Int = if (b == 0) a else mdc(b, a % b)
fun listaPrimosEmRange(range: IntRange): List<Int> = range.filter { it.isPrimo() }
