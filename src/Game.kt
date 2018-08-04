fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100

    var isBlessed = true
    var isInmortal = false

    // Karma
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20).toInt()

    // Aura
    val auraVisible = isBlessed && healthPoints > 50 || isInmortal
    // val auraColor = if (auraVisible) "GREEN" else "NONE"
    val auraColor = when (karma) {
        in 0..5 ->  "red"
        in 5..10 -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else -> "no color"
    }

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

    val healthPointsString = "Health Points: $healthPoints"
    val auraString = "Aura: $auraColor"
    val blessedString = "Blessed: ${if (isBlessed) "YES" else "NO"}"

    // Player status
    println("($healthPointsString) ($auraString) ($blessedString) -> $healthStatus")
}