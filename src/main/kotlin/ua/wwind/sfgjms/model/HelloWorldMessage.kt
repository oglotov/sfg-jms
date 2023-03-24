package ua.wwind.sfgjms.model

import java.io.Serializable
import java.util.UUID

data class HelloWorldMessage(
    val id: UUID,
    val message: String,
) : Serializable {
    companion object {
        const val serialVersionUID: Long = 1L
    }
}
