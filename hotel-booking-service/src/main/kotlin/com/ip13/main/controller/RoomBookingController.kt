package com.ip13.main.controller

import com.ip13.main.model.dto.request.RoomBookingRequest
import com.ip13.main.model.dto.response.RoomBookingResponse
import com.ip13.main.model.toRoomBookingResponse
import com.ip13.main.service.RoomBookingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/room-booking")
class RoomBookingController(
    private val roomBookingService: RoomBookingService
) {
    @GetMapping
    fun findAllBookings(): List<RoomBookingResponse> {
        return roomBookingService.findAll().map { it.toRoomBookingResponse() }
    }

    @PostMapping
    fun bookRoom(
        @RequestBody
        roomBookingRequest: RoomBookingRequest
    ): Int {
        return roomBookingService.save(roomBookingRequest).id
    }

    @DeleteMapping("/{id}")
    fun cancelBooking(
        @PathVariable
        id: Int
    ): ResponseEntity<Void> {
        roomBookingService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/id")
    fun findById(
        @PathVariable
        id: Int
    ): RoomBookingResponse {
        return roomBookingService.findById(id).toRoomBookingResponse()
    }
}