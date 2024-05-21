package com.ip13.main.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class HotelGrade(
    @Id
    val id: Int = 0,
    val hotelId: Int = 0,
    val grade: Int = 0,
)