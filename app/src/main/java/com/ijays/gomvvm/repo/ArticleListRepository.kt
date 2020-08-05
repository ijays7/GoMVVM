package com.ijays.gomvvm.repo

import com.ijays.gomvvm.db.ArticleDao
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.BannerModel
import com.ijays.gomvvm.model.api.ApiManager
import com.ijays.gomvvm.model.base.GeneralErrorHandlerImpl
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.model.base.WanResponse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
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

interface IArticleListRepository {

    fun getArticleList(): Flow<ViewState<List<ArticleModel>>>

    fun getBannerList(): Flow<ViewState<WanResponse<List<BannerModel>>>>
}

@Singleton
class DefaultArticleListRepository @Inject constructor(
    private val articleDao: ArticleDao,
    private val apiManager: ApiManager
) : IArticleListRepository {
    override fun getArticleList(): Flow<ViewState<List<ArticleModel>>> {
        return flow {
            val articleResponse = apiManager.service.getArticleList(0)
            val topArticleList = apiManager.service.getTopArticle()

            val resultList = topArticleList.data.toMutableList()
            resultList.addAll(articleResponse.data.datas)

            // Save articles to database
            articleDao.insertArticles(resultList)

            //
            emit(ViewState.success(resultList.toList()))

        }.catch {
            emit(ViewState.error(GeneralErrorHandlerImpl().getError(throwable = it)))
        }.flowOn(Dispatchers.IO)
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
@InstallIn(ActivityComponent::class)
interface ArticleListRepositoryModule {

    @Binds
    fun it(it: DefaultArticleListRepository): IArticleListRepository
}
