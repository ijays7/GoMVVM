package com.ijays.gomvvm.repo.data

import androidx.paging.PagingSource
import com.ijays.gomvvm.model.ArticleModel
import com.ijays.gomvvm.model.api.ApiManager
import com.ijays.gomvvm.model.base.WanResponse
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by ijays on 2020/8/9.
 */
private const val ARTICLE_STARTING_PAGE_INDEX = 1


class ArticlePagingSource(private val apiManager: ApiManager) :
    PagingSource<Int, ArticleModel>() {

    /**
     * This method is called to trigger the async load.
     * [params] keeps information related to the load operation, including:
     * - `Key of the page to be loaded`
     * - `Load Size`. The requested number of items to load
     *
     * This load function return a [LoadResult]. This can take one of the following types:
     * - [LoadResult.Page]，if the result was successful.
     * - [LoadResult.Error], if the result returned an error
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleModel> {
        val position = params.key ?: ARTICLE_STARTING_PAGE_INDEX
        return try {
            var topArticleResult: WanResponse<List<ArticleModel>>? = null
            val isFirstLoadOrRefresh = position == ARTICLE_STARTING_PAGE_INDEX

            if (isFirstLoadOrRefresh) {
                // Add top article
                topArticleResult = apiManager.service.getTopArticle()
            }

            val articleResult = apiManager.service.getArticleList(position)

            val result = if (isFirstLoadOrRefresh) {
                if (topArticleResult != null) {
                    val realResult = mutableListOf<ArticleModel>()
                    realResult.addAll(topArticleResult.data)
                    realResult.addAll(articleResult.data.datas)
                    realResult
                } else {
                    articleResult.data.datas
                }
            } else {
                articleResult.data.datas
            }
            LoadResult.Page(
                data = result,
                prevKey = if (position == ARTICLE_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (articleResult.data.datas.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }

    }

}