package com.example.models

import org.jetbrains.exposed.dao.id.IntIdTable
import java.time.LocalDateTime

object Cygnns : IntIdTable() {
    val lat = float("lat")
    val long = float("long")
    val sr = float("sr")
}

data class CsvData(
    val lat: Float,
    val long: Float,
    val sr: Float
)

data class CygnnsRequest(
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val coordinates: BoundingBox
)

data class Coordinate(
    val lat : Float,
    val long: Float
)

data class BoundingBox(
    val northEast: Coordinate,
    val southWest: Coordinate
)
