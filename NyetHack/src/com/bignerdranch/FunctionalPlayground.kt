package com.bignerdranch


fun main(args: Array<String>) {
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