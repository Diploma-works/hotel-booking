package com.ip13.main.model.dto.request

import java.time.LocalDateTime

data class HotelConstraintRequest(
    val hotelId: Int,
    val reason: String,
    val fromDate: LocalDateTime,
    val tillDate: LocalDateTime,
)
