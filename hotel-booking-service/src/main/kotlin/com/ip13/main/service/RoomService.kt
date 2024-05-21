package com.ip13.main.service

import com.ip13.main.exceptionHandling.exception.NotFoundException
import com.ip13.main.model.dto.request.RoomRequest
import com.ip13.main.model.entity.Room
import com.ip13.main.model.entity.RoomBooking
import com.ip13.main.model.toRoom
import com.ip13.main.repository.RoomRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class RoomService(
    private val roomRepository: RoomRepository,
    private val roomBookingService: RoomBookingService,
) {
    fun save(constraintRequest: RoomRequest): Room {
        return roomRepository.save(constraintRequest.toRoom())
    }

    fun findById(id: Int): Room {
        return roomRepository.findByIdOrNull(id)
            ?: throw NotFoundException("Room with $id not found")
    }

    fun findAll(): List<Room> {
        return roomRepository.findAll().toList()
    }

    fun getAvailableRooms(
        hotelId: Int,
        fromDate: LocalDateTime,
        tillDate: LocalDateTime,
    ): List<Room> {
        val rooms: List<Room> = roomRepository.findByHotelId(hotelId)
        val roomBookings: List<RoomBooking> = roomBookingService.findAll()

        return rooms.filter { room ->
            roomBookings.none {
                it.roomId == room.id && isDatesIntersect(fromDate, tillDate, it.fromDate, it.tillDate)
            }
        }
    }

    private fun isDatesIntersect(
        fromDate1: LocalDateTime,
        tillDate1: LocalDateTime,
        fromDate2: LocalDateTime,
        tillDate2: LocalDateTime,
    ): Boolean {
        return tillDate1 < fromDate2 || fromDate1 > tillDate2
    }
}