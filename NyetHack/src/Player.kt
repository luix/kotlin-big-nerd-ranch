class Player {
    val name = "madrigal"
        get() = field.capitalize()

    fun castFireball(numFireballs: Int = 2) =
            println("A glass of Fireball springs into existence. (x$numFireballs)")
}