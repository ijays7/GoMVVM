package com.ijays.gomvvm.ui.vh

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.R
import com.ijays.gomvvm.model.ArticleModel
import kotlinx.android.synthetic.main.item_article_list_layout.view.*

/**
 * Created by ijays on 2020/8/7.
 */
/**
 * viewHolder of article list
 */
class ArticleListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /**
     * bind view
     */
    fun bind(articleModel: ArticleModel) {
        articleModel.let {
            itemView.tvTitle.text = it.title
            itemView.tvChannel.text = "${it.superChapterName}·${it.chapterName}"
            itemView.tvName.text = if (it.author.isNullOrEmpty()) it.shareUser else it.author
            itemView.tvTime.text = it.niceDate
            // 是否是置顶
            itemView.tvTop.isVisible = it.type == 1

            if (it.desc.isNullOrEmpty()) {
                // do not have describe info，constrain the max title line to 3
                itemView.tvTitle.maxLines = 3
                itemView.tvDesc.isVisible = false
            } else {
                itemView.tvTitle.maxLines = 1
                itemView.tvDesc.text = it.desc
                itemView.tvDesc.isVisible = true
            }

        }
    }

    companion object {
        fun create(parent: ViewGroup): ArticleListVH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article_list_layout, parent, false)
            return ArticleListVH(view)
        }
    }
}