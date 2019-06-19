package com.bignerdranch.nyethack

open class Room(val name: String) {
    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {
    override fun load() = "The villagers rally and cheer as you enter!"
}