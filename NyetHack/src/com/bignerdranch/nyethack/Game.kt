package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player("Madrigal")
    player.castFireball(5)

    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    // Aura
    val auraColor = player.auraColor()

    // Player status
    printPlayerStatus(player)

    // Aura
    player.auraColor()
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}