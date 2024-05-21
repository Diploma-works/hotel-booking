package com.ip13.main.repository

import com.ip13.main.model.entity.HotelGrade
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelGradeRepository : CrudRepository<HotelGrade, Int> {
    fun findByHotelId(hotelId: Int): List<HotelGrade>
}