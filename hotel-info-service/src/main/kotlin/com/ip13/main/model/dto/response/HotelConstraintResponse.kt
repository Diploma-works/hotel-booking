package com.ip13.main.model.dto.response

import java.time.LocalDateTime

data class HotelConstraintResponse(
    val hotelId: Int,
    val reason: String,
    val fromDate: LocalDateTime,
    val tillDate: LocalDateTime,
)
