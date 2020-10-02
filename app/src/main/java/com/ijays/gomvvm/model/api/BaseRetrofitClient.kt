package com.ijays.gomvvm.model.api

import com.ijays.gomvvm.BuildConfig
import com.ijays.gomvvm.common.BASE_URL
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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
            logging.level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BASIC
            }

            builder.addInterceptor(logging)
                .connectTimeout(CONST_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(CONST_TIME_OUT, TimeUnit.SECONDS)

            handleBuilder(builder)

            return builder.build()
        }

    /**
     * subclass to override
     */
    protected abstract fun handleBuilder(builder: OkHttpClient.Builder)


    internal fun <T> getService(serviceClass: Class<T>) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(JsonUtil.getJsonConverter())
        .build().create(serviceClass)


}