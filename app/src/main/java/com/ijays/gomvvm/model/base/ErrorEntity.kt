package com.ijays.gomvvm.model.base

/**
 * Created by ijays on 2020/4/8.
 */
sealed class ErrorEntity {

    object Network : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    object Unknown : ErrorEntity()

}