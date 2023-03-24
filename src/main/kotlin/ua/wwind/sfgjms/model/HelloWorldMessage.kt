package ua.wwind.sfgjms.model

import java.io.Serializable
import java.util.UUID

data class HelloWorldMessage(
    var id: UUID = UUID.randomUUID(),
    var message: String = "",
) : Serializable {
    companion object {
        const val serialVersionUID: Long = 1L
    }
}
