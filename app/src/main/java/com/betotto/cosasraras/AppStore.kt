package com.betotto.cosasraras

import com.betotto.cosasraras.messages.MessagesState
import com.betotto.cosasraras.messages.messagesReducer
import org.reduxkotlin.Store
import org.reduxkotlin.createStore

data class AppState(val messagesState: MessagesState)

object AppStore {

    lateinit var store: Store<AppState>

    private fun rootReducer(state: AppState, action: Any) = AppState(
        messagesState = messagesReducer(state.messagesState, action)
    )

    fun init() {
        val initialState = AppState(MessagesState())
        store = createStore(::rootReducer, initialState)
    }
}



