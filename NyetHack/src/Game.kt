fun main(args: Array<String>) {

    val player = Player()
    player.castFireball(5)

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