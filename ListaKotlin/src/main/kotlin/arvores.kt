package org.example

sealed interface Tree<out T>

data class Node<out T>(
    val value: T,
    val left: Tree<T> = End,
    val right: Tree<T> = End
) : Tree<T> {
    override fun toString(): String {
        val children = if (left == End && right == End) "" else " $left $right"
        return "T($value$children)"
    }
}

object End : Tree<Nothing> {
    override fun toString() = "."
}

fun <T : Comparable<T>> adicionaNo(tree: Tree<T>, value: T): Tree<T> = when (tree) {
    is End -> Node(value)
    is Node -> if (value < tree.value)
        Node(tree.value, adicionaNo(tree.left, value), tree.right)
    else
        Node(tree.value, tree.left, adicionaNo(tree.right, value))
}

fun <T> Tree<T>.quantidadeDeNos(): Int = when (this) {
    is End -> 0
    is Node -> if (left == End && right == End) 1 else left.quantidadeDeNos() + right.quantidadeDeNos()
}

fun <T> Tree<T>.valorDosNos(): List<T> = when (this) {
    is End -> emptyList()
    is Node -> if (left == End && right == End) listOf(value) else left.valorDosNos() + right.valorDosNos()
}

fun <T> Tree<T>.converteParaString(): String = when (this) {
    is End -> ""
    is Node -> "$value(${left.converteParaString()},${right.converteParaString()})"
}

fun String.converteParaArvore(): Tree<Char> {
    if (isEmpty()) return End
    val value = this[0]
    val open = indexOf('(')
    if (open == -1) return Node(value)

    var balance = 0
    var split = open
    for (i in open + 1 until length) {
        if (this[i] == '(') balance++
        if (this[i] == ')') balance--
        if (this[i] == ',' && balance == 0) {
            split = i
            break
        }
    }

    val left = substring(open + 1, split)
    val right = substring(split + 1, length - 1)
    return Node(value, left.converteParaArvore(), right.converteParaArvore())
}
