fun main(args: Array<String>) {

    val player = Player()
    player.castFireball(5)

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isInmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player status
    printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)

    printTestMessage()
}

private fun printTestMessage() {
    var name: String
    var healthPoints: Int
    healthPoints = 73
    name = "LuiX"
    healthPoints += 27
    println("I'm $name and my health ${formatHealthStatus(healthPoints, true)}")
}

private fun printPlayerStatus(auraColor: String,
                              isBlessed: Boolean,
                              name: String,
                              healthStatus: String) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

// Challenge: Single-Expression Functions
// Can you convert auraColor to use a single-expression function syntax?
private fun auraColor(isBlessed: Boolean, healthPoints: Int, isInmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isInmortal) "green" else "none"

// Challenge: Fireball Inerbation Level
private fun inerbationLevel(fireballs: Int) =
        if (fireballs * 5 < 50) (fireballs * 5) else 50

// Challenge: Inerbation Status
private fun inerbationStatus(inerbation: Int) = when (inerbation) {
    in 1..10 -> "tipsy"
    in 11..20 -> "sloshed"
    in 21..30 -> "soused"
    in 31..40 -> "stewed"
    in 41..50 -> "..t0aSt3d"
    else -> "no hay pex"
}