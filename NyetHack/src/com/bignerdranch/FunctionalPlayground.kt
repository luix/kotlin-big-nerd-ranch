package com.bignerdranch


fun main(args: Array<String>) {

    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
            .map{ animal -> "A baby $animal" }
            .map{ baby -> "$baby, with the cutest little tail ever!"}
    println(babies)

    println(animals)

}