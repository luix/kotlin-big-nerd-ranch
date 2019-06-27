package com.bignerdranch.nyethack

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    coroutineWorkers()

    playPingPong()
}


fun playPingPong() {
    val job1 = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(200)
        println("Pong")
        delay(200)
    }
    GlobalScope.launch() {
        delay(200)
        println("Ping")
        job1.join()
        println("Ping")
        delay(200)
    }
    Thread.sleep(1000)
}


fun coroutineWorkers() {
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