package com.ijays.gomvvm.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ijays.gomvvm.R
import com.ijays.gomvvm.adapter.item.articleListItemView
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.ui.viewmodel.ArticleListViewModel
import com.ijays.gomvvm.utils.observeNotNull
import com.ijays.gomvvm.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Main page
 */
class MainActivity : AppCompatActivity() {

    private val articleListViewModel: ArticleListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            getArticleLivaData().observeNotNull(this@MainActivity) { state ->
                when (state) {
                    is ViewState.Success -> {
                        articleList.withModels {
                            state.data.forEach {
                                articleListItemView {
                                    id(it.id)
                                    title(it.title)
                                    authorName(if (it.author.isNullOrEmpty()) it.shareUser else it.author)
                                    topArticle(it.type == 1)
                                    describe(it.desc)
                                    channel("${it.superChapterName}·${it.chapterName}")
                                    time(it.niceDate)
                                    itemClickListener { _ ->
                                        toast("OMG, wait a second...")
                                    }
                                }
                            }
                        }
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
