package com.ijays.gomvvm.ui.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.R
import com.ijays.gomvvm.databinding.ItemLoadStateFooterBinding

/**
 * Created by ijays on 2020/8/16.
 */
class ArticleLoadStateVH(view: View, retry: () -> Unit) : RecyclerView.ViewHolder(view) {
    private val binding = ItemLoadStateFooterBinding.bind(view)

    init {
        binding.retryButton.setOnClickListener {
            retry.invoke()
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState !is LoadState.Loading
        binding.errorMsg.isVisible = loadState !is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): ArticleLoadStateVH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_load_state_footer, parent, false)
            return ArticleLoadStateVH(view, retry)
        }
    }
}