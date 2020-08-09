package com.ijays.gomvvm.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.BannerModel
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.model.base.WanResponse
import com.ijays.gomvvm.repo.IArticleListRepository
import kotlinx.coroutines.flow.Flow

/**
 * ViewModel for article List
 * Created by ijays on 2020/4/4.
 */
class ArticleListViewModel @ViewModelInject constructor(private val articleListRepository: IArticleListRepository) :
    ViewModel() {

    private val bannerListLD: LiveData<ViewState<WanResponse<List<BannerModel>>>> =
        articleListRepository.getBannerList().asLiveData()

    /**
     * get liveData for article list
     */
    fun getArticleLivaData(): Flow<PagingData<ArticleModel>> {
        return articleListRepository.getArticleList()
    }

    /**
     * get liveData for banner list
     */
    fun getBannerListLiveData() = bannerListLD
}