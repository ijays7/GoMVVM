package com.ijays.gomvvm.model.base

/**
 * Created by ijays on 2020/4/8.
 */
interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorEntity
}