package org.example

fun main() {
    println("LISTAS")
    val lista = listOf(1, 1, 2, 3, 5, 8)
    println("Último: ${ultimo(lista)}")
    println("Penúltimo: ${penultimo(lista)}")
    println("É palíndroma? ${isPalindrome(listOf(1, 2, 3, 2, 1))}")

    val texto = "aaaabccaadeeee".toList()
    val codificado = codificaLista(texto)
    println("Codificação Run-Length: $codificado")
    println("Decodificação: ${decodifica(codificado)}")

    println("\nARITMÉTICA")
    println("7 é primo? ${7.isPrimo()}")
    println("MDC de 36 e 63: ${mdc(36, 63)}")
    println("Primos entre 7 e 31: ${listaPrimosEmRange(7..31)}")

    println("\nÁRVORES")
    var arvore: Tree<Char> = End
    val valores = listOf('d', 'b', 'f', 'a', 'c', 'e', 'g')
    for (v in valores) arvore = adicionaNo(arvore, v)

    println("Árvore construída: $arvore")
    println("Quantidade de folhas: ${arvore.quantidadeDeNos()}")
    println("Valores das folhas: ${arvore.valorDosNos()}")

    val arvoreStr = (arvore as Node<Char>).converteParaString()
    println("Árvore convertida para string: $arvoreStr")

    val reconstruida = arvoreStr.converteParaArvore()
    println("Árvore reconstruída: $reconstruida")
}
