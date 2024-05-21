package com.ip13.main.kafka

import com.ip13.main.event.HotelCreatedEvent
import com.ip13.main.service.HotelService
import org.springframework.kafka.annotation.KafkaListener

class HotelCreatedEventListener(
    private val hotelService: HotelService,
) {
    @KafkaListener(
        topics = [HOTEL_CREATED_TOPIC],
        containerFactory = "hotelCreatedEventConsumer",
        groupId = "hotel-created",
    )
    fun notifyHotelCreated(event: HotelCreatedEvent) {
        hotelService.save(event)
    }

    companion object {
        private const val HOTEL_CREATED_TOPIC = "hotel-created"
    }
}