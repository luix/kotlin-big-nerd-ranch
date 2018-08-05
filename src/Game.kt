fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100

    var isBlessed = true
    var isInmortal = false

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isInmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    printTestMessage()
    castFireball()
}

private fun printPlayerStatus(auraColor: String,
                              isBlessed: Boolean,
                              name: String,
                              healthStatus: String) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean,
                      healthPoints: Int,
                      isInmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isInmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int,
                               isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    return healthStatus
}

private fun printTestMessage() {
    var name: String
    var healthPoints: Int
    healthPoints = 73
    name = "LuiX"
    healthPoints += 27
    println("I'm $name and my health ${formatHealthStatus(healthPoints, true)}")
}

private fun castFireball(numFireballs: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}