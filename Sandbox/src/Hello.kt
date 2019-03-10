fun main(args: Array<String>) {
    println("Hello, world!")

    // Chapter 5. Anonymous Functions and the Function Type
    val numLetters = "Mississippi".count({ letter ->
        letter == 's'
    })
    println(numLetters)
}

