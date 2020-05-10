package com.betotto.cosasraras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.betotto.cosasraras.login.LoginFragment
import com.betotto.cosasraras.messages.MessagesContainerFragment
import com.facebook.soloader.SoLoader
import org.reduxkotlin.Store
import org.reduxkotlin.StoreSubscription

class MainActivity: AppCompatActivity(), LoginFragment.LoginFragmentListener  {
    private lateinit var store: Store<AppState>
    private lateinit var unsubscribe: StoreSubscription
    private lateinit var fragmentLogin: Fragment
    private lateinit var fragmentMessage: Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false)

        fragmentLogin = LoginFragment()
        fragmentMessage = MessagesContainerFragment()

        AppStore.init()

        store = AppStore.store

        unsubscribe = store.subscribe { Log.i("PERRO","From Main: ${store.state.toString()}") }


        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.main_view, fragmentLogin).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        unsubscribe()
    }

    override fun doLogin(feature: String) {
        var newView: Fragment = fragmentLogin
                when (feature) {
                    "messages" -> newView = fragmentMessage
                }
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right)
            .replace(R.id.main_view, newView)
            .addToBackStack(null)
            .commit()
    }
}
