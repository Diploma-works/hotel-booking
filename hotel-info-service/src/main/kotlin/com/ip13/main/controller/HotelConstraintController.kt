package com.ip13.main.controller

import com.ip13.main.model.dto.request.HotelConstraintRequest
import com.ip13.main.model.dto.response.HotelConstraintResponse
import com.ip13.main.model.toHotelConstraintResponse
import com.ip13.main.service.HotelConstraintService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("hotel-constraint")
class HotelConstraintController(
    private val hotelConstraintService: HotelConstraintService,
) {
    @GetMapping("/{id}")
    fun getHotel(
        @PathVariable
        id: Int,
    ): HotelConstraintResponse {
        return hotelConstraintService.findById(id).toHotelConstraintResponse()
    }

    @PostMapping
    fun createHotel(
        hotelConstraintRequest: HotelConstraintRequest,
    ): Int {
        return hotelConstraintService.save(hotelConstraintRequest).id
    }
}