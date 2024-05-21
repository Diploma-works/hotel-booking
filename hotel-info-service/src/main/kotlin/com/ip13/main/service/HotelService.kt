package com.ip13.main.service

import com.ip13.main.exceptionHandling.exception.NotFoundException
import com.ip13.main.model.dto.request.HotelRequest
import com.ip13.main.model.entity.Hotel
import com.ip13.main.model.entity.HotelConstraint
import com.ip13.main.model.toHotel
import com.ip13.main.repository.HotelRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class HotelService(
    private val hotelRepository: HotelRepository,
    private val hotelConstraintService: HotelConstraintService,
) {
    fun save(hotelRequest: HotelRequest): Hotel {
        return hotelRepository.save(hotelRequest.toHotel())
    }

    fun findById(id: Int): Hotel {
        return hotelRepository.findByIdOrNull(id) ?: throw NotFoundException("Hotel with id: $id not found")
    }

    fun getAvailableHotels(
        address: String,
        fromDate: LocalDateTime,
        tillDate: LocalDateTime,
    ): List<Hotel> {
        val hotelConstraints: List<HotelConstraint> = hotelConstraintService.findAll()

        return hotelRepository.findByAddress(address).filter { hotel ->
            hotelConstraints.none {
                it.hotelId == hotel.id && !isDatesIntersect(fromDate, tillDate, it.fromDate, it.tillDate)
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

