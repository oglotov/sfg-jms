package ua.wwind.sfgjms.listener

import jakarta.jms.Message
import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import ua.wwind.sfgjms.config.JmsConfig
import ua.wwind.sfgjms.model.HelloWorldMessage

@Component
class HelloMessageListener {
    @JmsListener(destination = JmsConfig.MY_QUEUE)
    fun listen(@Payload helloWorldMessage: HelloWorldMessage, @Headers headers: MessageHeaders, message: Message) {
        println(helloWorldMessage)
    }
}