package com.ijays.gomvvm.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.R
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.utils.inflate
import kotlinx.android.synthetic.main.item_article_list_layout.view.*

/**
 * Created by ijays on 2020/4/10.
 */
class ArticleListAdapter : RecyclerView.Adapter<ArticleListAdapter.ArticleListVH>() {

    private var dataList: List<ArticleModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleListVH(
        parent.inflate(
            R.layout.item_article_list_layout
        )
    )

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ArticleListVH, position: Int) =
        holder.bind(dataList[position])

    fun replaceItems(items: List<ArticleModel>) {
        dataList = items
        notifyItemRangeChanged(0, items.size)
    }


    class ArticleListVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(articleModel: ArticleModel) = with(itemView) {
            tvTitle.text = articleModel.title
        }

    }
}