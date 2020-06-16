private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

tailrec fun removeZeros(x: Int): Int =
        if (x % 10 == 0) removeZeros(x / 10) else x

fun f(x: Int) = removeZeros(x + 1)

fun reachableNumbers(num: Int): HashSet<Int> {
    var n = num
    val reached = HashSet<Int>() // a mutable hash set
    while (reached.add(n)) n = f(n)
    return reached
}

fun main() {
    var n = readInt() // use input-helper function to read an int
    val reached = reachableNumbers(n)
    println(reached.size)
}

/*
fun main(args: Array<String>) {
    //var num: Int = readLine()
    val test = listOf(1098, 10)
    for (num in test) {
        println("$num -> ${reachableNumbers(num)}")
    }
}
 */