package com.ip13.main.service

import com.ip13.main.model.dto.request.HotelGradeRequest
import com.ip13.main.model.entity.HotelGrade
import com.ip13.main.model.toHotelGrade
import com.ip13.main.repository.HotelGradeRepository
import org.springframework.stereotype.Service

@Service
class HotelGradeService(
    private val hotelGradeRepository: HotelGradeRepository,
) {
    fun save(hotelGradeRequest: HotelGradeRequest): HotelGrade {
        return hotelGradeRepository.save(hotelGradeRequest.toHotelGrade())
    }

    fun findByHotelId(id: Int): List<HotelGrade> {
        return hotelGradeRepository.findByHotelId(id)
    }
}

