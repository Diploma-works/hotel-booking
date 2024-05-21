package com.ip13.main.kafka

import com.ip13.main.event.HotelCreatedEvent
import org.springframework.kafka.annotation.KafkaListener

class HotelCreatedEventListener {
    @KafkaListener(
        topics = [HOTEL_CREATED_TOPIC],
        containerFactory = "hotelCreatedEventConsumer",
        groupId = "hotel-created",
    )
    fun notifyHotelCreated(event: HotelCreatedEvent) {
        println(event)
    }

    companion object {
        private const val HOTEL_CREATED_TOPIC = "hotel-created"
    }
}