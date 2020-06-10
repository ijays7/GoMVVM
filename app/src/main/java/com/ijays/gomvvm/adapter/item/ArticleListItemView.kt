package com.ijays.gomvvm.adapter.item

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.airbnb.epoxy.ModelProp
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
    private val tvName: TextView
    private val tvTopArticle: TextView

    init {
        inflate(context, R.layout.item_epoxy_article_list, this)

        tvTitle = findViewById(R.id.tvTitle)
        tvName = findViewById(R.id.tvName)
        tvTopArticle = findViewById(R.id.tvTop)
    }

    @TextProp
    fun setTitle(title: CharSequence?) {
        tvTitle.text = title ?: ""
    }

    @TextProp
    fun setAuthorName(name: CharSequence?) {
        tvName.text = name ?: ""
    }

    @ModelProp
    fun topArticle(visible: Boolean) {
        tvTopArticle.isVisible =visible
    }

}
