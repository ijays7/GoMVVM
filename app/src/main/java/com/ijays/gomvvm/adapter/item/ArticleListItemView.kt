package com.ijays.gomvvm.adapter.item

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.ijays.gomvvm.R

/**
 * Created by ijays on 2020/6/6.
 */
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class ArticleListItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private val tvTitle: TextView

    init {
        inflate(context, R.layout.item_epoxy_article_list, this)

        tvTitle = findViewById(R.id.tvTitle)
    }

    @TextProp
    fun setTitle(title: CharSequence?) {
        tvTitle.text = title ?: ""
    }

}
