package ua.wwind.sfgjms

import org.apache.activemq.artemis.api.core.TransportConfiguration
import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl
import org.apache.activemq.artemis.core.server.ActiveMQServer
import org.apache.activemq.artemis.core.server.ActiveMQServers
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SfgJmsApplication

fun main(args: Array<String>) {
/*
    val server: ActiveMQServer = ActiveMQServers.newActiveMQServer(
        ConfigurationImpl()
            .setPersistenceEnabled(false)
            .setJournalDirectory("target/data/journal")
            .setSecurityEnabled(false)
            .addAcceptorConfiguration("invm", "vm://0")
    )

    server.start()
*/

    runApplication<SfgJmsApplication>(*args)
}
