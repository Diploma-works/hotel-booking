package com.ip13.main.controller

import com.ip13.main.model.dto.request.HotelGradeRequest
import com.ip13.main.service.HotelGradeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/grade")
class GradeController(
    private val hotelGradeService: HotelGradeService,
) {

    @PostMapping
    fun createRoom(
        @RequestBody
        hotelGradeRequest: HotelGradeRequest,
    ): Int {
        return hotelGradeService.save(hotelGradeRequest).id
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable
        hotelId: Int
    ): Int {
        val grades = hotelGradeService.findByHotelId(hotelId)
        return grades.sumOf { it.grade } / grades.size
    }
}