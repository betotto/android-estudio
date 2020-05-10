package com.betotto.cosasraras

import android.graphics.Color
import com.facebook.litho.Column
import com.facebook.litho.Component
import com.facebook.litho.ComponentContext
import com.facebook.litho.Row
import com.facebook.litho.annotations.LayoutSpec
import com.facebook.litho.annotations.OnCreateLayout
import com.facebook.litho.annotations.Prop
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.yoga.YogaAlign
import com.facebook.yoga.YogaJustify

@LayoutSpec
object MyComponentSpec {

    @OnCreateLayout
    fun onCreateLayout(c: ComponentContext?): Component {
        val viewComponent = RecyclerCollectionComponent.create(c)
            .disablePTR(true)
            .section(ListGroup.create(SectionContext(c)).build())
            .build()
        return Column.create(c)
            .child(
                Row.create(c)
                    .widthPercent(100f)
                    .heightPercent(70f)
                    .child(viewComponent)
                    .justifyContent(YogaJustify.CENTER)
                    .alignContent(YogaAlign.CENTER)
            )
            .child(
                Row.create(c)
                    .child(
                        Row.create(c)
                            .widthPercent(100f)
                            .heightPercent(100f)
                            .backgroundColor(Color.rgb(120, 255, 110))
                            .child(ButtonText.create(c).text("Hello"))
                    )
                    .widthPercent(100f)
                    .heightPercent(30f)
                    .alignItems(YogaAlign.CENTER)
            )
            .build()
    }
}