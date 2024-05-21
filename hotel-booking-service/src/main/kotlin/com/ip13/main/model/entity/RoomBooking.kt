package com.ip13.main.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class RoomBooking(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val roomId: Int = 0,
    val fromDate: LocalDateTime = LocalDateTime.now(),
    val tillDate: LocalDateTime = LocalDateTime.now(),
)