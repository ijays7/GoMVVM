package com.ijays.gomvvm.model.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

/**
 * Created by ijays on 2020/10/2.
 */
object JsonUtil {
    private val contentType = "application/json".toMediaType()

    val jsonFormat = Json {
        ignoreUnknownKeys = true
    }

    fun getJsonConverter() = jsonFormat.asConverterFactory(contentType = contentType)
}