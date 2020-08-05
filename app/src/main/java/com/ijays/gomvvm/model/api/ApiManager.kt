package com.ijays.gomvvm.model.api

import com.ijays.gomvvm.api.ApiService
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ijays on 2020/4/6.
 */
@Singleton
class ApiManager @Inject constructor() : BaseRetrofitClient() {

    val service by lazy {
        getService(ApiService::class.java)
    }

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        //
    }

}