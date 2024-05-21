package com.ip13.main.kafka

import com.ip13.main.service.HotelService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ListenerConfig(
    private val hotelService: HotelService,
) {
    @Bean
    fun hotelCreatedEventListener(): HotelCreatedEventListener {
        return HotelCreatedEventListener(hotelService)
    }
}