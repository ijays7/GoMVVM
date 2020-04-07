package com.ijays.gomvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijays.gomvvm.model.ArticleListModel
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.model.base.WanResponse
import com.ijays.gomvvm.repo.ArticleListRepository

/**
 * Created by ijays on 2020/4/4.
 */
class ArticleListViewModel(articleListRepository: ArticleListRepository) : ViewModel() {

    private val articleListLD: LiveData<ViewState<WanResponse<ArticleListModel>>> =
        articleListRepository.getArticleList().asLiveData()


    fun getArticleLivaData() = articleListLD
}