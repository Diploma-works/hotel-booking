package com.ip13.main.kafka

import com.ip13.main.event.HotelCreatedEvent
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.ssl.DefaultSslBundleRegistry
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
@ConfigurationProperties(prefix = "kafka")
class HotelCreatedEventConsumerProperties {
    lateinit var consumer: Map<String, KafkaProperties.Consumer>

    @Bean
    fun hotelCreatedEventConsumer(): ConcurrentKafkaListenerContainerFactory<String, HotelCreatedEvent> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, HotelCreatedEvent> =
            ConcurrentKafkaListenerContainerFactory()
        factory.consumerFactory = consumerFactory("hotel-created-event-consumer")
        return factory
    }

    private fun consumerFactory(consumerName: String): ConsumerFactory<String, Any> {
        val bundleProperties = DefaultSslBundleRegistry()
        val properties = consumer[consumerName]?.buildProperties(bundleProperties)
            ?: throw RuntimeException("No properties found for consumer $consumerName")
        properties.putAll(KafkaProperties.Ssl().buildProperties(bundleProperties))
        properties.putAll(KafkaProperties.Security().buildProperties())
        return DefaultKafkaConsumerFactory(properties)
    }
}