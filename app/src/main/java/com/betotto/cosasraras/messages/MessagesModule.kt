package com.betotto.cosasraras.messages

data class AddMessage(val text: String, val completed: Boolean = false)
// data class ToggleTodo(val index: Int)
// data class SetVisibilityFilter(val visibilityFilter: VisibilityFilter)

fun messagesReducer(state: MessagesState, action: Any): MessagesState = when (action) {
    is AddMessage -> MessagesState(
        state.messages + Message(
            action.text,
            id = state.messagesCount + 1
        ), state.messagesCount + 1
    )
    else -> state
}
