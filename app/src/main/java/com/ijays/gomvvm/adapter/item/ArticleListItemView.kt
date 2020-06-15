package com.ijays.gomvvm.adapter.item

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.airbnb.epoxy.*
import com.ijays.gomvvm.R
import kotlinx.android.synthetic.main.item_epoxy_article_list.view.*

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
    private val tvDesc: TextView

    init {
        inflate(context, R.layout.item_epoxy_article_list, this)

        tvTitle = findViewById(R.id.tvTitle)
        tvName = findViewById(R.id.tvName)
        tvTopArticle = findViewById(R.id.tvTop)
        tvDesc = findViewById(R.id.tvDesc)
    }

    /**
     * set item click listener
     */
    var itemClickListener: View.OnClickListener? = null
        @CallbackProp set

    @AfterPropsSet
    fun useProps() {
        // This is optional , and is called after the annotated properties above are set.
        // This is useful for using several properties in one method to guarantee they are all set first.
        setOnClickListener(itemClickListener)
    }

    @TextProp
    fun setTitle(title: CharSequence?) {
        tvTitle.text = title ?: ""
    }

    @TextProp
    fun setAuthorName(name: CharSequence?) {
        tvName.text = name ?: ""
    }

    /**
     * set description
     */
    @TextProp
    fun setDescribe(desc: CharSequence?) {
        if (desc.isNullOrEmpty()) {
            // do not have describe info，constrain the max title line to 3
            tvTitle.maxLines = 3
            tvDesc.isVisible = false
        } else {
            tvTitle.maxLines = 1
            tvDesc.text = desc
            tvDesc.isVisible = true
        }
    }

    @TextProp
    fun setChannel(channel: CharSequence?) {
        tvChannel.text = channel ?: ""
    }

    @TextProp
    fun setTime(time: CharSequence?) {
        tvTime.text = time ?: ""
    }

    /**
     * set if the article if top article
     */
    @ModelProp
    fun topArticle(visible: Boolean) {
        tvTopArticle.isVisible = visible
    }

}
