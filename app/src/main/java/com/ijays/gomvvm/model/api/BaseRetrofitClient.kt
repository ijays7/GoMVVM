package com.ijays.gomvvm.model.api

import com.ijays.gomvvm.BuildConfig
import com.ijays.gomvvm.common.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by ijays on 2020/4/6.
 */
abstract class BaseRetrofitClient {
    companion object {
        const val CONST_TIME_OUT = 20L
    }

    private val client: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder()

            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.BASIC
            }

            builder.addInterceptor(logging)
                .connectTimeout(CONST_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(CONST_TIME_OUT,TimeUnit.SECONDS)

            handleBuilder(builder)

            return builder.build()
        }

    /**
     * subclass to override
     */
    protected abstract fun handleBuilder(builder:OkHttpClient.Builder)


    internal fun <T> getService(serviceClass: Class<T>) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(serviceClass)


}