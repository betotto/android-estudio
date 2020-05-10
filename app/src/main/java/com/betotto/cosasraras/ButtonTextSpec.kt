package com.betotto.cosasraras

import android.text.Layout
import com.facebook.litho.ClickEvent
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.Section
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.widget.Text
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaEdge

@LayoutSpec
object ButtonTextSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext?, @Prop text: String): Component = Text.create(c)
        .text(text)
        .textSizeDip(18f)
        .textColorRes(android.R.color.white)
        .textSizeSp(18f)
        .textAlignment(Layout.Alignment.ALIGN_CENTER)
        .alignSelf(YogaAlign.STRETCH)
        .paddingDip(YogaEdge.ALL, 8f)
        .build()

   /* @OnEvent(ClickEvent::class)
    fun onClick(c: ComponentContext) {
        ListGroup.setList(SectionContext(c))
    }*/
}