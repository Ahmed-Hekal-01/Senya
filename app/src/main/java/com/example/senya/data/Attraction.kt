package com.example.senya.data

import com.squareup.moshi.Json

data class Attraction(
    val description: String = "",
    val facts: List<String> = listOf(),
    val id: String = "",
    @param:Json(name = "image_urls") val imageUrls: List<String> = listOf(),
    val location: Location = Location(),
    @param:Json(name = "months_to_visit") val monthToVisit: String = "",
    val title: String = ""
) {
    data class Location(
        val latitude: String = "",
        val longitude: String = ""
    )
}