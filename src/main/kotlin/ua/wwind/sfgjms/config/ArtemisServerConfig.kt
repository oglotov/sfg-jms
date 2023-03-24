package ua.wwind.sfgjms.config

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl
import org.apache.activemq.artemis.core.server.ActiveMQServer
import org.apache.activemq.artemis.core.server.ActiveMQServers
import org.apache.activemq.artemis.core.server.impl.ActiveMQServerImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

//@Configuration
class ArtemisServerConfig {
    @Bean(initMethod = "start", destroyMethod = "stop")
    fun artemisServer(): ActiveMQServer {
        val configuration = ConfigurationImpl().apply {
            isPersistenceEnabled = false
            journalDirectory = "target/data/journal"
            largeMessagesDirectory = "target/data/large-messages"
            addAcceptorConfiguration("tcp", "tcp://localhost:61616")
        }.setSecurityEnabled(false)
        return ActiveMQServers.newActiveMQServer(configuration)
    }
}
