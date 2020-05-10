package com.betotto.cosasraras.messages

import android.graphics.Color
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaEdge

@LayoutSpec
object MessageItemSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext,
                       @Prop message: Message): Component =
        Column.create(c)
            .paddingDip(YogaEdge.ALL, 16f)
            .backgroundColor(Color.WHITE)
            .child(
                Text.create(c)
                    .text(message.text)
                    .textSizeSp(40f))
            .child(
                Text.create(c)
                    .text("completed: ${message.completed.toString()}")
                    .textSizeSp(20f))
            .build();
}