package com.bignerdranch.nyethack.extensions

fun frame(name: String, padding: Int, formatChar: String = "*"): String {
    val greeting = "$name!"
    val middle = formatChar.padEnd(padding)
            .plus(greeting)
            .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}


fun main() {
    println("Welcome, Madrigal".frame(5))
    
   /*
    ******************************
    *     Welcome, Madrigal      *
    ******************************
    */
}