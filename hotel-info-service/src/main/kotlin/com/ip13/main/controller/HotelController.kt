package com.ip13.main.controller

import com.ip13.main.model.dto.request.HotelRequest
import com.ip13.main.model.dto.response.HotelResponse
import com.ip13.main.model.entity.Hotel
import com.ip13.main.model.toHotelResponse
import com.ip13.main.service.HotelService
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/hotel")
class HotelController(
    private val hotelService: HotelService,
) {
    @GetMapping("/{id}")
    fun getHotel(
        @PathVariable
        id: Int,
    ): HotelResponse {
        return hotelService.findById(id).toHotelResponse()
    }

    @PostMapping
    fun createHotel(
        hotelRequest: HotelRequest,
    ): Int {
        return hotelService.save(hotelRequest).id
    }

    @GetMapping
    fun getAvailableHotels(
        address: String,
        fromDate: LocalDateTime,
        tillDate: LocalDateTime,
    ): List<Hotel> {
        return hotelService.getAvailableHotels(address, fromDate, tillDate)
    }
}
