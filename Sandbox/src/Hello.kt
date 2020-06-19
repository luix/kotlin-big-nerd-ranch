// https://codelabs.developers.google.com/codelabs/kotlin-bootcamp-functions/#5

val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

val lazyMap = decorations.asSequence().map {
    println("access: $it")
}

val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
    println("access: $it")
    it
}

fun main() {

    // eager, creates a new list
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: " + eager)

    // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: " + filtered)

    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: " + newList)

    println("lazy: $lazyMap")
    println("-----")
    println("first: ${ lazyMap.first() }")
    println("-----")
    println("all: ${ lazyMap.toList() }")

    println("=====")
    println("filtered: ${ lazyMap2.toList() }")
}
