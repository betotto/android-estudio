package com.betotto.cosasraras

import com.facebook.litho.StateValue
import com.facebook.litho.annotations.OnCreateInitialState
import com.facebook.litho.annotations.OnUpdateState
import com.facebook.litho.annotations.State
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection

@GroupSectionSpec
object ListGroupSpec {

    @OnCreateInitialState
    fun onCreateInitialState(c: SectionContext, items: StateValue<List<String>>) {
        items.set(listOf("hello", "vaca", "srrro", "adfadsfadf", "doublPerro"))
    }

    @OnCreateChildren
    fun onCreateChildren(c: SectionContext, @State items: List<String>): Children {
        val children = Children.create()
        for (item in items) {
            children.child(
                SingleComponentSection.create(c)
                    .key(item)
                    .component(InListItem.create(c).text(item))
            )
        }
        return children.build()
    }

    @OnUpdateState
    fun setList(items: StateValue<List<String>>) {
        items.set(listOf("perro", "triple", "volador0", "dsfadf", "doublPerro"))
    }
}
