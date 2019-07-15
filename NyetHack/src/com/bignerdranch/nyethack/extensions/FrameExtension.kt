package com.bignerdranch.nyethack.extensions

fun frame(name: String, padding: Int, formatChar: String = "*"): String {
    val greeting = "$name!"
    val middle = formatChar.padEnd(padding)
            .plus(greeting)
            .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}

fun String.framer(padding: Int, formatChar: String = "*"): String {
    val greeting = "$this"
    val middle = formatChar.padEnd(padding)
            .plus(greeting)
            .plus(formatChar.padStart(padding))
    val doodle = (1 until middle.length).joinToString("") { formatChar }
    return "$doodle\n$middle\n$doodle"
}

fun main(args: Array<String>) {
    println("Welcome, Madrigal".framer(5))

   /*
    ******************************
    *     Welcome, Madrigal      *
    ******************************
    */
}