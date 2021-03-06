package com.ijays.core.base.state

/**
 * Encapsulate View State
 */
sealed class ViewState<ResultType> {
    /**
     * load success
     */
    data class Success<ResultType>(val data: ResultType) : ViewState<ResultType>()

    /**
     * loading resources
     */
    class Loading<ResultType> : ViewState<ResultType>()

    /**
     * Describe error state of the UI
     */
    data class Error<ResultType>(val error: ErrorEntity) : ViewState<ResultType>()

    companion object {
        /**
         * Creates [ViewState] object with [Success] state and [data]
         */
        fun <ResultType> success(data: ResultType): ViewState<ResultType> = Success(data)

        /**
         * Creates [ViewState] object with [loading] state to notify the UI to show loading
         */
        fun <ResultType> loading(): ViewState<ResultType> = Loading()

        /**
         * Creates [ViewState] object with [Error] state and [errorEntity]
         */
        fun <ResultType> error(errorEntity: ErrorEntity): ViewState<ResultType> =
            Error(errorEntity)
    }
}
