package com.ijays.gomvvm.ui.vh

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.R
import kotlinx.android.synthetic.main.item_load_state_footer.view.*

/**
 * Created by ijays on 2020/8/16.
 */
class ArticleLoadStateVH(view: View, retry: () -> Unit) : RecyclerView.ViewHolder(view) {
    init {
        itemView.retry_button.setOnClickListener {
            retry.invoke()
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            itemView.error_msg.text = loadState.error.localizedMessage
        }
        itemView.progress_bar.isVisible = loadState is LoadState.Loading
        itemView.retry_button.isVisible = loadState !is LoadState.Loading
        itemView.error_msg.isVisible = loadState !is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): ArticleLoadStateVH {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_load_state_footer, parent, false)
            return ArticleLoadStateVH(view, retry)
        }
    }
}