package com.ijays.gomvvm.ui.vh

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.R
import com.ijays.gomvvm.common.EXTRA_DATA
import com.ijays.gomvvm.databinding.ItemArticleListLayoutBinding
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.BrowserLoadOptionModel
import com.ijays.gomvvm.ui.activity.BrowserActivity

/**
 * Created by ijays on 2020/8/7.
 */
/**
 * viewHolder of article list
 */
class ArticleListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemArticleListLayoutBinding.bind(itemView)

    /**
     * bind view
     */
    fun bind(articleModel: ArticleModel) {
        articleModel.let {
            showContent(binding.tvTitle, it.title)
            binding.tvChannel.text = "${it.superChapterName}·${it.chapterName}"
            binding.tvName.text = if (it.author.isNullOrEmpty()) it.shareUser else it.author
            binding.tvTime.text = it.niceDate
            // 是否是置顶
            binding.tvTop.isVisible = it.type == 1

            if (it.desc.isNullOrEmpty()) {
                // do not have describe info，constrain the max title line to 3
                binding.tvTitle.maxLines = 3
                binding.tvDesc.isVisible = false
            } else {
                binding.tvTitle.maxLines = 1
                binding.tvDesc.isVisible = true
                showContent(binding.tvDesc, it.desc)
            }

            binding.root.setOnClickListener { v ->
                val context = v.context
                if (context !is Activity) return@setOnClickListener

                val intent = Intent(context, BrowserActivity::class.java).also { temp ->
                    temp.putExtra(
                        EXTRA_DATA,
                        BrowserLoadOptionModel(it.link, binding.tvTitle.text.toString())
                    )
                }

                val options = ActivityOptions.makeSceneTransitionAnimation(
                    context,
                    v,
                    "shared_element_container"
                )

                context.startActivity(intent, options.toBundle())
            }
        }
    }

    private fun showContent(textView: TextView, content: String) {
        textView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(content)
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