package ua.wwind.sfgjms.sender

import org.springframework.jms.core.JmsTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ua.wwind.sfgjms.config.JmsConfig
import ua.wwind.sfgjms.model.HelloWorldMessage
import java.util.*

@Component
class HelloSender(
    val jmsTemplate: JmsTemplate,
) {
    @Scheduled(fixedRate = 2_000)
    fun sendMessage() {

        println("I'm sending a message")
        val message = HelloWorldMessage(id = UUID.randomUUID(), message = "Hello World!")
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message)
        println("Message sent")

    }
}