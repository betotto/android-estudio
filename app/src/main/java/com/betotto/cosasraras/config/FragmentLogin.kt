package com.betotto.cosasraras.config

import android.os.Bundle
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

class FragmentLogin: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val c = ComponentContext(activity?.applicationContext)

        val component = RecyclerCollectionComponent.create(c)
            .disablePTR(true)
            .section(BarSection.create(SectionContext(c)).data(AppStore.store.getState().messagesState.messages).build()).build()

        return LithoView.create(
            activity?.applicationContext,
            component
        )
    }
}