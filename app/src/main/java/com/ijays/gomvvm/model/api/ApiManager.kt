package com.ijays.gomvvm.model.api

import com.ijays.gomvvm.api.ApiService
import okhttp3.OkHttpClient

/**
 * Created by ijays on 2020/4/6.
 */
object ApiManager : BaseRetrofitClient() {

    val service by lazy {
        getService(ApiService::class.java)
    }

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        //
    }

}