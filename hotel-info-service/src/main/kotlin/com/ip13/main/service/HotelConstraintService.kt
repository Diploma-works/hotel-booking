package com.ip13.main.service

import com.ip13.main.exceptionHandling.exception.NotFoundException
import com.ip13.main.model.dto.request.HotelConstraintRequest
import com.ip13.main.model.entity.HotelConstraint
import com.ip13.main.model.toHotelConstraint
import com.ip13.main.repository.HotelConstraintRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class HotelConstraintService(
    private val hotelConstraintRepository: HotelConstraintRepository,
) {
    fun save(constraintRequest: HotelConstraintRequest): HotelConstraint {
        return hotelConstraintRepository.save(constraintRequest.toHotelConstraint())
    }

    fun findById(id: Int): HotelConstraint {
        return hotelConstraintRepository.findByIdOrNull(id)
            ?: throw NotFoundException("HotelConstraint with $id not found")
    }

    fun findAll(): List<HotelConstraint> {
        return hotelConstraintRepository.findAll().toList()
    }
}