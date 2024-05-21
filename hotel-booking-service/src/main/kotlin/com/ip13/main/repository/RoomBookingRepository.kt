package com.ip13.main.repository

import com.ip13.main.model.entity.RoomBooking
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RoomBookingRepository : CrudRepository<RoomBooking, Int>