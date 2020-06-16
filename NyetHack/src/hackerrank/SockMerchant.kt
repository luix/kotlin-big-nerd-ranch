package hackerrank

import java.util.*
import kotlin.collections.HashMap

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val socks = HashMap<Int, Int>()
    for (n in ar) {
        val count = socks.get(n) ?: 0
        socks.put(n, count + 1)
    }
    var pairs = 0
    socks.forEach { k, v ->
        pairs += (v / 2)
    }
    return pairs
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
