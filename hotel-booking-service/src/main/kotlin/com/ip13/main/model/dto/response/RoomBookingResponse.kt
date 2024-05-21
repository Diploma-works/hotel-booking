package com.ip13.main.model.dto.response

import java.time.LocalDateTime

data class RoomBookingResponse(
    val roomId: Int,
    val fromDate: LocalDateTime,
    val tillDate: LocalDateTime,
)