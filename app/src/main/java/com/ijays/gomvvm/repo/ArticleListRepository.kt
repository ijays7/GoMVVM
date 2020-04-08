package com.ijays.gomvvm.repo

import com.ijays.gomvvm.model.ArticleListModel
import com.ijays.gomvvm.model.api.ApiManager
import com.ijays.gomvvm.model.base.GeneralErrorHandlerImpl
import com.ijays.gomvvm.model.base.ViewState
import com.ijays.gomvvm.model.base.WanResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by ijays on 2020/4/4.
 */
class ArticleListRepository(private val apiManager: ApiManager) {

    fun getArticleList(): Flow<ViewState<WanResponse<ArticleListModel>>> {
        return flow {
            val articleResponse = apiManager.service.getArticleList(0)

            emit(ViewState.success(articleResponse))
        }.catch {
            emit(ViewState.error(GeneralErrorHandlerImpl().getError(throwable = it)))
        }.flowOn(Dispatchers.IO)

    }


}