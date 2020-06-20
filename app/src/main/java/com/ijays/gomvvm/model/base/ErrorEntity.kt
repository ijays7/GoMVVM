package com.ijays.gomvvm.model.base

/**
 * Define errors
 * Created by ijays on 2020/4/8.
 */
sealed class ErrorEntity {
    /**
     * Network errors
     */
    object Network : ErrorEntity()

    /**
     * Resource not found error
     */
    object NotFound : ErrorEntity()

    /**
     * Access denied error
     */
    object AccessDenied : ErrorEntity()

    /**
     * Service unavailable error
     */
    object ServiceUnavailable : ErrorEntity()

    /**
     * Unknown error
     */
    object Unknown : ErrorEntity()

}