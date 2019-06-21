package com.bignerdranch.nyethack

enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0))
}

data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}