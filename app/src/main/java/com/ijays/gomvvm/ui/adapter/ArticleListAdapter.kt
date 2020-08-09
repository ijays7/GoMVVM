package com.ijays.gomvvm.ui.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.ui.vh.ArticleListVH

/**
 * The [PagingDataAdapter] gets notified whenever the [PagingData] content is loaded and then it
 * signals RecyclerView to update.
 *
 * Created by ijays on 2020/8/7.
 */
class ArticleListAdapter :
    PagingDataAdapter<ArticleModel, RecyclerView.ViewHolder>(REPO_CREATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleListVH.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            (holder as ArticleListVH).bind(item)
        }
    }


    companion object {
        private val REPO_CREATOR = object : DiffUtil.ItemCallback<ArticleModel>() {
            override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel) =
                oldItem == newItem
        }
    }
}