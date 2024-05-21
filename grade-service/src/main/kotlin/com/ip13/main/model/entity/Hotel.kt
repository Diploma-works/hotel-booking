package com.ip13.main.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Hotel(
    @Id
    val id: Int = 0,
    val managerId: Int = 0,
)