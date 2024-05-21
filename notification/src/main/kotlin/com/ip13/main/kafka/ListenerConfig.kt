package com.ip13.main.kafka

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ListenerConfig {
    @Bean
    fun hotelCreatedEventListener(): HotelCreatedEventListener {
        return HotelCreatedEventListener()
    }
}