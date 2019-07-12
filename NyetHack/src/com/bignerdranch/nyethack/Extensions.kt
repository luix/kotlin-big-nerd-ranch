package com.bignerdranch.nyethack

fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun main(args: Array<String>) {
    println("Madrigal has left the building".addEnthusiasm(2))
}
