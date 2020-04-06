package com.ijays.gomvvm.model.base

/**
 * Created by ijays on 2020/4/2.
 */
sealed class ViewState<ResultType> {

    data class Success<ResultType>(val data: ResultType) : ViewState<ResultType>()
}
