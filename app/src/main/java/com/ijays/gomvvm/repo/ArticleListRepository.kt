package com.ijays.gomvvm.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ijays.core.base.repo.IRepository
import com.ijays.core.base.state.GeneralErrorHandlerImpl
import com.ijays.core.base.state.ViewState
import com.ijays.gomvvm.db.ArticleDao
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.BannerModel
import com.ijays.gomvvm.model.api.ApiManager
import com.ijays.gomvvm.model.base.WanResponse
import com.ijays.gomvvm.repo.data.ArticlePagingSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ijays on 2020/4/4.
 */

private const val ARTICLE_LIST_PAGE_SIZE = 20

interface IArticleListRepository : IRepository {

    fun getArticleList(): Flow<PagingData<ArticleModel>>

    fun getBannerList(): Flow<ViewState<WanResponse<List<BannerModel>>>>
}

@ViewModelScoped
class DefaultArticleListRepository @Inject constructor(
    private val articleDao: ArticleDao,
    private val apiManager: ApiManager
) : IArticleListRepository {
    override fun getArticleList(): Flow<PagingData<ArticleModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = ARTICLE_LIST_PAGE_SIZE,
                enablePlaceholders = false
            ), pagingSourceFactory = {
                ArticlePagingSource(apiManager)
            }
        ).flow
    }

    override fun getBannerList(): Flow<ViewState<WanResponse<List<BannerModel>>>> {
        return flow {
            emit(ViewState.success(apiManager.service.getBanner()))
        }.catch {
            emit(ViewState.error(GeneralErrorHandlerImpl().getError(throwable = it)))
        }.flowOn(Dispatchers.IO)
    }

}

@Module
@InstallIn(ViewModelComponent::class)
interface ArticleListRepositoryModule {

    @Binds
    fun it(it: DefaultArticleListRepository): IArticleListRepository
}
