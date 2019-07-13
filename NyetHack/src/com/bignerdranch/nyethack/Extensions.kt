package com.bignerdranch.nyethack

val String.numVowels
    get() = count { "aeiou".contains(it) }

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint(): T {
    println(this)
    return this
}

fun main(args: Array<String>) {
    "Madrigal has left the building".easyPrint().addEnthusiasm(2).easyPrint()
    24.easyPrint()

    34.let {  }
}
