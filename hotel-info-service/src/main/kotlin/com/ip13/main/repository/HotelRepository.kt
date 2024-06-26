package com.ip13.main.repository

import com.ip13.main.model.entity.Hotel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : CrudRepository<Hotel, Int> {
    fun findByAddress(address: String): List<Hotel>
}