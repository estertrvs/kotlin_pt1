package org.example

fun <T> ultimo(list: List<T>): T = list.last()
fun <T> penultimo(list: List<T>): T = list[list.size - 2]
fun <T> isPalindrome(list: List<T>): Boolean = list == list.reversed()

fun codificaLista(chars: List<Char>): List<Pair<Int, Char>> {
    val result = mutableListOf<Pair<Int, Char>>()
    var count = 1
    for (i in 1 until chars.size) {
        if (chars[i] == chars[i - 1]) count++
        else {
            result.add(Pair(count, chars[i - 1]))
            count = 1
        }
    }
    result.add(Pair(count, chars.last()))
    return result
}

fun decodifica(pairs: List<Pair<Int, Char>>): List<Char> {
    val result = mutableListOf<Char>()
    for ((count, char) in pairs) repeat(count) { result.add(char) }
    return result
}
