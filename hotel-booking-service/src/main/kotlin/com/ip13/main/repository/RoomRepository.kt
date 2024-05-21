package com.ip13.main.repository

import com.ip13.main.model.entity.Room
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomRepository : CrudRepository<Room, Int> {
    fun findByHotelId(hotelId: Int): List<Room>
}