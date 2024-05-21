package com.ip13.main.model.dto.request

import java.time.LocalDateTime

data class RoomBookingRequest(
    val roomId: Int,
    val fromDate: LocalDateTime,
    val tillDate: LocalDateTime,
)