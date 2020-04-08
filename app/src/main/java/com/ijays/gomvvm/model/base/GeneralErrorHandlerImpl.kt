package com.ijays.gomvvm.model.base

import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

/**
 * Created by ijays on 2020/4/8.
 */
class GeneralErrorHandlerImpl : ErrorHandler {

    override fun getError(throwable: Throwable): ErrorEntity {
        return when (throwable) {
            is IOException -> ErrorEntity.Network

            is HttpException -> {
                when (throwable.code()) {
                    HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied

                    HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable

                    else -> ErrorEntity.Unknown
                }

            }
            else -> ErrorEntity.Unknown
        }

    }
}