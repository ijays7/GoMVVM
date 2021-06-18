package com.ijays.gomvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.paging.PagingData
import com.ijays.core.base.state.ViewState
import com.ijays.core.base.viewmodel.BaseViewModel
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.BannerModel
import com.ijays.gomvvm.model.base.WanResponse
import com.ijays.gomvvm.repo.IArticleListRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * ViewModel for article List
 * Created by ijays on 2020/4/4.
 */
@HiltViewModel
class ArticleListViewModel @Inject constructor(private val articleListRepository: IArticleListRepository) :
    BaseViewModel() {

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