package ua.wwind.sfgjms.listener

import jakarta.jms.Message
import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import ua.wwind.sfgjms.config.JmsConfig
import ua.wwind.sfgjms.model.HelloWorldMessage
import java.util.*

@Component
class HelloMessageListener(
    val jmsTemplate: JmsTemplate,
) {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    fun listen(@Payload helloWorldMessage: HelloWorldMessage, @Headers headers: MessageHeaders, message: Message) {
        println(helloWorldMessage)
    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    fun listenForHello(@Payload helloWorldMessage: HelloWorldMessage, @Headers headers: MessageHeaders, message: Message) {
        println(helloWorldMessage)
        val messageReply = HelloWorldMessage(id = UUID.randomUUID(), message = "World!")
        jmsTemplate.convertAndSend(message.jmsReplyTo, messageReply)
    }
}