package com.ip13.main.model

import com.ip13.main.model.dto.request.HotelGradeRequest
import com.ip13.main.model.entity.HotelGrade

fun HotelGradeRequest.toHotelGrade(): HotelGrade {
    return HotelGrade(
        hotelId = this.hotelId,
        grade = this.grade,
    )
}