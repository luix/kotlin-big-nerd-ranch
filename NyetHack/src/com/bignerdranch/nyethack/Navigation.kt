package com.bignerdranch.nyethack

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}