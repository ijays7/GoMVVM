package com.ijays.core.base.state

/**
 * Created by ijays on 2020/10/5.
 */
interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorEntity
}