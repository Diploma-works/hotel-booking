package com.ip13.main.model.dto.request

data class HotelRequest(
    val managerId: Int,
    val name: String,
    val address: String,
    val description: String,
)