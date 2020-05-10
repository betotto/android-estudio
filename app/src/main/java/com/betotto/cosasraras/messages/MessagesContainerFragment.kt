package com.betotto.cosasraras.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.betotto.cosasraras.AppStore
import com.betotto.cosasraras.R

class MessagesContainerFragment: Fragment() {

    private lateinit var fragmentScroll: ScrollFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.messages_container, container, false)

        fragmentScroll = ScrollFragment()
        val newMessage = view.findViewById<Button>(R.id.new_message)

        newMessage.setOnClickListener { AppStore.store
            .dispatch(AddMessage("Perro del mal ${AppStore.store.getState().messagesState.messagesCount}")) }
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_scroll, fragmentScroll)
            ?.commit()

        return view
    }
}