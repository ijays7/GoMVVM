package com.ijays.gomvvm.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.R
import com.ijays.gomvvm.base.BaseActivity
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.ui.adapter.ArticleListAdapter
import com.ijays.gomvvm.ui.viewmodel.ArticleListViewModel
import com.ijays.gomvvm.utils.observeNotNull
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Main page
 */
class MainActivity : BaseActivity() {

    private val articleListViewModel: ArticleListViewModel by viewModels()

    private val articleAdapter by lazy {
        ArticleListAdapter()
    }

    private var articleListJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        initData()

        articleListViewModel.apply {
            getBannerListLiveData().observeNotNull(this@MainActivity) { state ->
                when (state) {
                    is ViewState.Success -> {
                        val bannerList = state.data.data
                        bannerList.forEach {
                            Log.e("SONGJIE", "state==>$it")
                        }
                    }
                }
            }
        }
    }

    private fun initView() {
        initAdapter()

        retry_button.setOnClickListener {
            articleAdapter.retry()
        }
    }

    private fun initAdapter() {
        articleList.apply {

            adapter = with(articleAdapter) {
                addLoadStateListener { loadState ->
                    // Only show the list when refresh succeeds
                    articleList.isVisible = loadState.refresh is LoadState.NotLoading

                    progressbar.isVisible = loadState.refresh is LoadState.Loading
                    // Show the retry state if initial load or refresh failed
                    retry_button.isVisible = loadState.refresh is LoadState.Error
                }
                articleAdapter
            }

            layoutManager = LinearLayoutManager(
                this@MainActivity, RecyclerView.VERTICAL,
                false
            )
        }
    }

    private fun initData() {
        articleListJob?.cancel()
        articleListJob = lifecycleScope.launch {
            articleListViewModel.getArticleLivaData().collect {
                articleAdapter.submitData(it)
            }
        }
    }
}
