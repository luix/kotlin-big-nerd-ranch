fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100

    var isBlessed = true
    var isInmortal = false

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isInmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

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

    // Player status
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println(name + " " + healthStatus)
}