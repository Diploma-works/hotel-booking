package com.ip13.main.service

import com.ip13.main.exceptionHandling.exception.NotFoundException
import com.ip13.main.model.dto.request.RoomBookingRequest
import com.ip13.main.model.entity.RoomBooking
import com.ip13.main.model.toRoomBooking
import com.ip13.main.repository.RoomBookingRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RoomBookingService(
    private val roomBookingRepository: RoomBookingRepository,
) {
    fun save(roomBookingRequest: RoomBookingRequest): RoomBooking {
        return roomBookingRepository.save(roomBookingRequest.toRoomBooking())
    }

    fun findById(id: Int): RoomBooking {
        return roomBookingRepository.findByIdOrNull(id)
            ?: throw NotFoundException("Room booking with id: $id not found")
    }

    fun findAll(): List<RoomBooking> {
        return roomBookingRepository.findAll().toList()
    }

    fun delete(id: Int) {
        roomBookingRepository.deleteById(id)
    }
}

