package ua.wwind.sfgjms.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType

@Configuration
class JmsConfig {
    @Bean
    fun messageConverter(): MessageConverter {
        val converter = MappingJackson2MessageConverter().apply {
            setTargetType(MessageType.TEXT)
            setTypeIdPropertyName("_type")
        }
        return converter
    }
}