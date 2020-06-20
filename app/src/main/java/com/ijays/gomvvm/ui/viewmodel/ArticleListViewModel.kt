package com.ijays.gomvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ijays.gomvvm.model.ArticleListModel
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.BannerModel
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.model.base.WanResponse
import com.ijays.gomvvm.repo.ArticleListRepository

/**
 * ViewModel for article List
 * Created by ijays on 2020/4/4.
 */
class ArticleListViewModel(articleListRepository: ArticleListRepository) : ViewModel() {

    private val articleListLD: LiveData<ViewState<List<ArticleModel>>> =
        articleListRepository.getArticleList().asLiveData()

    private val bannerListLD: LiveData<ViewState<WanResponse<List<BannerModel>>>> =
        articleListRepository.getBannerList().asLiveData()

    /**
     * get liveData for article list
     */
    fun getArticleLivaData() = articleListLD

    /**
     * get liveData for banner list
     */
    fun getBannerListLiveData() = bannerListLD
}