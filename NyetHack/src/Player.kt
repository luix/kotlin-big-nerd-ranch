class Player {
    var name = "madrigal"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    var healthPoints = 89
    var isBlessed = true
    private var isInmortal = false


    private fun auraColor_(isBlessed: Boolean,
                           healthPoints: Int,
                           isInmortal: Boolean): String {
        val auraVisible = isBlessed && healthPoints > 50 || isInmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
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

    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}