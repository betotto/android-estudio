package com.betotto.cosasraras.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.betotto.cosasraras.R

class LoginFragment: Fragment() {

    private lateinit var listener: LoginFragmentListener
    private lateinit var button: Button

    interface LoginFragmentListener {
        fun doLogin(feature: String)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login, container, false)

        button = view.findViewById<Button>(R.id.login_button)

        button.setOnClickListener {
            listener.doLogin("messages")
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is LoginFragmentListener) {
            context as LoginFragmentListener
        } else {
            throw RuntimeException("${context.toString()} must implement LoginFragmentListener")
        }
    }
}