package com.ip13.main.model

import com.ip13.main.model.dto.request.HotelConstraintRequest
import com.ip13.main.model.dto.request.HotelRequest
import com.ip13.main.model.dto.response.HotelConstraintResponse
import com.ip13.main.model.dto.response.HotelResponse
import com.ip13.main.model.entity.Hotel
import com.ip13.main.model.entity.HotelConstraint

fun HotelRequest.toHotel(): Hotel {
    return Hotel(
        managerId = this.managerId,
        name = this.name,
        address = this.address,
        description = this.description,
    )
}

fun Hotel.toHotelResponse(): HotelResponse {
    return HotelResponse(
        managerId = this.managerId,
        name = this.name,
        address = this.address,
        description = this.description,
    )
}

fun HotelConstraintRequest.toHotelConstraint(): HotelConstraint {
    return HotelConstraint(
        hotelId = this.hotelId,
        reason = this.reason,
        fromDate = this.fromDate,
        tillDate = this.tillDate,
    )
}

fun HotelConstraint.toHotelConstraintResponse(): HotelConstraintResponse {
    return HotelConstraintResponse(
        hotelId = this.hotelId,
        reason = this.reason,
        fromDate = this.fromDate,
        tillDate = this.tillDate,
    )
}