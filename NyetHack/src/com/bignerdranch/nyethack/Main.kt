package com.bignerdranch.nyethack

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    (1..10000).forEach {
        GlobalScope.launch {
            val threadName = Thread.currentThread().name
            println("$it printed on thread ${threadName}")
        }
    }
    println("I'm going to sleep...")
    Thread.sleep(1000)
    println("Awake again!")
    }
}