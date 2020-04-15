package com.ijays.gomvvm.api

import com.ijays.gomvvm.model.ArticleListModel
import com.ijays.gomvvm.model.BannerModel
import com.ijays.gomvvm.model.base.WanResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ijays on 2020/4/2.
 */
interface ApiService {

    @GET("article/list/{id}/json")
    suspend fun getArticleList(@Path("id") id: Int):WanResponse<ArticleListModel>

    @GET("/banner/json")
    suspend fun getBanner():WanResponse<List<BannerModel>>

}