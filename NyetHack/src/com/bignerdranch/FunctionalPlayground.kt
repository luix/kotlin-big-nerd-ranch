package com.bignerdranch


fun main(args: Array<String>) {
    val itemsOfManyColors = listOf(listOf("red apple", "green apple", "blue apple"),
            listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana"))

    val redItems = itemsOfManyColors.flatMap { it.filter { it.contains("red") } }
    println(redItems)
    // [red apple, red fish]
}


fun flatteringTwoLists() {
    listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap { it }
    // [1, 2, 3, 4, 5, 6]
}

// Transforms category of functions
fun sameNumberOfItemsDifferentTypes() {
    val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
    val tenDollarWordLenghts = tenDollarWords.map { it.length }
    println(tenDollarWordLenghts)
    // [10, 9, 7]
    println(tenDollarWords.size)
    // 3
    println(tenDollarWordLenghts.size)
    // 3
}

// Transforms category of functions
fun aTailOfBabiesAnimals() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
            .map{ animal -> "A baby $animal" }
            .map{ baby -> "$baby, with the cutest little tail ever!"}
    println(babies)
    println(animals)
}