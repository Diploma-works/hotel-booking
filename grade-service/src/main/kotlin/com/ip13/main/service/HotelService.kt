package com.ip13.main.service

import com.ip13.main.event.HotelCreatedEvent
import com.ip13.main.exceptionHandling.exception.NotFoundException
import com.ip13.main.model.entity.Hotel
import com.ip13.main.repository.HotelRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class HotelService(
    private val hotelRepository: HotelRepository,
) {
    fun save(hotelCreatedEvent: HotelCreatedEvent): Hotel {
        return hotelRepository.save(Hotel(id = hotelCreatedEvent.hotelId, managerId = hotelCreatedEvent.managerId))
    }

    fun findById(id: Int): Hotel {
        return hotelRepository.findByIdOrNull(id) ?: throw NotFoundException("Hotel with id: $id not found")
    }
}

