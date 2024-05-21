package com.ip13.main.model

import com.ip13.main.model.dto.request.RoomBookingRequest
import com.ip13.main.model.dto.request.RoomRequest
import com.ip13.main.model.dto.response.RoomBookingResponse
import com.ip13.main.model.dto.response.RoomResponse
import com.ip13.main.model.entity.Room
import com.ip13.main.model.entity.RoomBooking

fun RoomRequest.toRoom(): Room {
    return Room(
        hotelId = this.hotelId,
        number = this.number,
        numOfBeds = this.numOfBeds,
    )
}

fun RoomBookingRequest.toRoomBooking(): RoomBooking {
    return RoomBooking(
        roomId = this.roomId,
        fromDate = this.fromDate,
        tillDate = this.tillDate
    )
}

fun Room.toRoomResponse(): RoomResponse {
    return RoomResponse(
        hotelId = this.hotelId,
        number = this.number,
        numOfBeds = this.numOfBeds,
    )
}

fun RoomBooking.toRoomBookingResponse(): RoomBookingResponse {
    return RoomBookingResponse(
        roomId = this.roomId,
        fromDate = this.fromDate,
        tillDate = this.tillDate
    )
}