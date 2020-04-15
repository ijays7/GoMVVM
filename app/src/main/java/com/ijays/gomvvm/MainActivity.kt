package com.ijays.gomvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ijays.gomvvm.adapter.ArticleListAdapter
import com.ijays.gomvvm.model.ArticleListModel
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.model.base.WanResponse
import com.ijays.gomvvm.ui.viewmodel.ArticleListViewModel
import com.ijays.gomvvm.utils.observeNotNull
import com.ijays.gomvvm.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val articleListViewModel: ArticleListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArticleListAdapter()
        articleList.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,
            false
        )
        articleList.adapter = adapter

        articleListViewModel.apply {
            getBannerListLiveData().observeNotNull(this@MainActivity) { state ->
                when (state) {
                    is ViewState.Success -> {
                        val bannerList=state.data.data
                        bannerList.forEach {
                            Log.e("SONGJIE","state==>$it")
                        }
                    }
                }
            }

            getArticleLivaData().observeNotNull(this@MainActivity) { state ->
                when (state) {
                    is ViewState.Success -> {
                        adapter.replaceItems(state.data.data.datas)
                        progressbar.isVisible = false
                    }
                    is ViewState.Loading -> progressbar.isVisible = true
                    is ViewState.Error -> {
                        progressbar.isVisible = false
                        toast("Something went wrong…")
                    }
                }
            }
        }

    }
}
