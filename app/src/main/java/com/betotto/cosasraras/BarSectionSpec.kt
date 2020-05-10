package com.betotto.cosasraras

import android.R.attr
import com.betotto.cosasraras.messages.Message
import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.widget.RecyclerCollectionComponent

@GroupSectionSpec
object BarSectionSpec {

    @OnCreateChildren
    fun onCreateChildren(
        c: SectionContext,
        @Prop data: List<Message>): Children {
        val builder = Children.create()
       /* builder.child(
            GroupSection.create(c)
                .key("vaca")
                .headerTitle("Vaca doble")
                .data(data))
        builder.child(ListGroup.create(c).build())*/
        return builder.build()
    }
}