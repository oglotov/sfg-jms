package ua.wwind.sfgjms.sender

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ua.wwind.sfgjms.config.JmsConfig
import ua.wwind.sfgjms.model.HelloWorldMessage
import java.util.*

@Component
class HelloSender(
    val jmsTemplate: JmsTemplate,
    val objectMapper: ObjectMapper,
) {
    @Scheduled(fixedRate = 2_000)
    fun sendMessage() {

        println("I'm sending a message")
        val message = HelloWorldMessage(id = UUID.randomUUID(), message = "Hello World!")
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message)
        println("Message sent")

    }

    @Scheduled(fixedRate = 2_000)
    fun sendAndReceiveMessage() {

        println("I'm sending a message")
        val message = HelloWorldMessage(id = UUID.randomUUID(), message = "Hello")
        val receivedMsg = jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RCV_QUEUE, MessageCreator {
            it.createTextMessage(objectMapper.writeValueAsString(message)).apply {
                setStringProperty("_type", "ua.wwind.sfgjms.model.HelloWorldMessage")
            }
        })
        val value = receivedMsg?.getBody(String::class.java)
        println(value?.let { objectMapper.readValue<HelloWorldMessage>(it) })

    }
}