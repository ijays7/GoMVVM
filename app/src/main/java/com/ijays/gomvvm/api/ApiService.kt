package com.ijays.gomvvm.api

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by ijays on 2020/4/2.
 */
interface ApiService {

    @GET("article/list/{id}/json")
    suspend fun getArticleList(@Path("id") id: Int)

}