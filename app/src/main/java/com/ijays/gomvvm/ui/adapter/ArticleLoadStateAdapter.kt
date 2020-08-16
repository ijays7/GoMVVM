package com.ijays.gomvvm.ui.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.ijays.gomvvm.ui.vh.ArticleLoadStateVH

/**
 * Created by ijays on 2020/8/16.
 */
class ArticleLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<ArticleLoadStateVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ArticleLoadStateVH {
        return ArticleLoadStateVH.create(parent, retry = retry)
    }

    override fun onBindViewHolder(holder: ArticleLoadStateVH, loadState: LoadState) {
        holder.bind(loadState)
    }

}