package com.bignerdranch.nyethack

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun Any.easyPrint(): Any {
    println(this)
    return this
}

fun main(args: Array<String>) {
    "Madrigal has left the building".addEnthusiasm(2).easyPrint()
    24.easyPrint()
}
