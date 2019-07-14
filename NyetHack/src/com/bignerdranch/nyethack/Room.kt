package com.bignerdranch.nyethack

open class Room(val name: String) {
    open val dangerLevel = 5
    var monster: Monster? = Goblin()

    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel\n" +
            "Creature: ${monster?.description ?: "none"}"

    open fun load() = "Nothing much to see here..."
}

open class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"

    final override fun load() =
            "The villagers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announce your arrival. $bellSound"
}