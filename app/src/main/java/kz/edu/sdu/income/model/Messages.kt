package kz.edu.sdu.income.model

data class Message(
    val message: String,
    val type: MessageType
)

enum class MessageType{
    AiMessage,
    UserMessage
}