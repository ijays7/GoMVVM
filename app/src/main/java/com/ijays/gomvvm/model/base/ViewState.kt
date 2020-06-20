package com.ijays.gomvvm.model.base

/**
 * Created by ijays on 2020/4/2.
 */
sealed class ViewState<ResultType> {
    /**
     * load success
     */
    data class Success<ResultType>(val data: ResultType) : ViewState<ResultType>()

    /**
     * Loading resource
     */
    class Loading<ResultType> : ViewState<ResultType>()

    /**
     * Describe error state of the UI
     */
    data class Error<ResultType>(val errorEntity: ErrorEntity) : ViewState<ResultType>()

    companion object {
        /**
         * Creates [ViewState] object with [Success] state and [data]
         */
        fun <ResultType> success(data: ResultType): ViewState<ResultType> = Success(data)

        /**
         * Creates [ViewState] object with [Loading] state to notify the UI to show loading
         */
        fun <ResultType> loading(): ViewState<ResultType> = Loading()

        /**
         * Creates [ViewState] object with [Error] state and [errorEntity]
         */
        fun <ResultType> error(errorEntity: ErrorEntity): ViewState<ResultType> = Error(errorEntity)
    }

}
