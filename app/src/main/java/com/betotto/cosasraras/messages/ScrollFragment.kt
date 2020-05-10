package com.betotto.cosasraras.messages

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.betotto.cosasraras.AppStore
import com.betotto.cosasraras.BarSection
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import org.reduxkotlin.StoreSubscription

class ScrollFragment: Fragment() {

    private lateinit var unsubscribe: StoreSubscription
    private lateinit var lithoView: LithoView
    private lateinit var c: ComponentContext

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val component = RecyclerCollectionComponent.create(c)
            .disablePTR(true)
            .section(ListaMensajes.create(SectionContext(c))
                .messagesList(AppStore.store.getState().messagesState.messages)).build()

        lithoView = LithoView.create(
            c,
            component
        )

        return lithoView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        c = ComponentContext(context)
        unsubscribe = AppStore.store.subscribe {
            val messagesState = AppStore.store.getState().messagesState
            lithoView.setComponentAsync(
                RecyclerCollectionComponent.create(c)
                    .disablePTR(true)
                    .section(ListaMensajes.create(SectionContext(c))
                        .messagesList(AppStore.store.getState().messagesState.messages)).build())
            Log.i("PERRO","From Main: ${AppStore.store.state.toString()}")
        }
    }

    override fun onDetach() {
        super.onDetach()
        unsubscribe()
    }

}