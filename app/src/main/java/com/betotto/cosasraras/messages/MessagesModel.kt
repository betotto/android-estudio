package com.betotto.cosasraras.messages

data class Message(
    val text: String,
    val completed: Boolean = false,
    val id: Int
)

data class MessagesState(
    val messages: List<Message> = emptyList(),
    val messagesCount: Int = 0
)
