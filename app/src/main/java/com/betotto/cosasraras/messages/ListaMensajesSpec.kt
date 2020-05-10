package com.betotto.cosasraras.messages

import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection

@GroupSectionSpec
object ListaMensajesSpec {

    @OnCreateChildren
    fun onCreateChildren(c: SectionContext,
                         @Prop messagesList: List<Message>): Children {
        val builder = Children.create()
        for(message in messagesList) {
            builder.child(
                SingleComponentSection.create(c)
                    .key(message.text)
                    .component(MessageItem.create(c).message(message).build()));
        }

        return builder.build()
    }
}