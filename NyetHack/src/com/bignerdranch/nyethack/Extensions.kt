package com.bignerdranch.nyethack

import com.sun.org.apache.xpath.internal.operations.Bool

val String.numVowels
    get() = count { "aeiou".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

infix fun String?.printWithDefault(default: String) = println(this ?: default)

/**
 * Extension to Int that determines whether a number is prime
 */
fun Int.isPrime(): Boolean {
    (2 until this).map {
        if (this % it == 0) return false
    }
    return true
}

/**
 * Optimizes eXtension to Int that determines whether a number is prime
 */
fun Int.isPrimeOptimized(): Boolean {
    if (this < 4) return true           // [1, 2, 3] are prime numbers
    if (this % 2 == 0) return false     // none other even numbers are prime except from 2, so eliminate them
    val halfPlusOne = this.div(2) + 1
    var result = true
    (4 until halfPlusOne).map {
        it
    }.filter {
        it % 2 == 1
    }.map {
        if (this % it == 0) return false
    }
    return true
}


fun main(args: Array<String>) {
    "Madrigal has left the building".easyPrint().addEnthusiasm(2).easyPrint()
    24.easyPrint()
    "how many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default String"
}
