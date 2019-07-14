package com.bignerdranch.nyethack

/**
 * function to allow a [Room] to be configured with a pit [Goblin].
 */
fun Room.configurePitGoblin(block: Room.(Goblin) -> Goblin): Room {
    val goblin = block(Goblin("Pit Goblin", description = "An Evil Pit Goblin"))
    monster = goblin
    return this
}