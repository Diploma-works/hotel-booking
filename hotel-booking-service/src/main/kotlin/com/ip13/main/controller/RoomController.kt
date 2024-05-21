package com.ip13.main.controller

import com.ip13.main.model.dto.request.RoomRequest
import com.ip13.main.model.dto.response.RoomResponse
import com.ip13.main.model.toRoomResponse
import com.ip13.main.service.RoomService
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/room")
class RoomController(
    private val roomService: RoomService,
) {

    @PostMapping
    fun createRoom(
        @RequestBody
        roomRequest: RoomRequest,
    ): Int {
        return roomService.save(roomRequest).id
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable
        id: Int
    ): RoomResponse {
        return roomService.findById(id).toRoomResponse()
    }

    @GetMapping
    fun findAll(): List<RoomResponse> {
        return roomService.findAll().map { it.toRoomResponse() }
    }

    @GetMapping("/hotel/{id}")
    fun findAvailableRoom(
        @PathVariable
        hotelId: Int,
        @RequestParam
        fromDate: LocalDateTime,
        @RequestParam
        tillDate: LocalDateTime
    ): List<RoomResponse> {
        return roomService.getAvailableRooms(hotelId, fromDate, tillDate).map { it.toRoomResponse() }
    }
}