package com.ijays.gomvvm.model.base

import kotlinx.serialization.Serializable

/**
 * base model
 *
 * Created by ijays on 2020/4/5.
 */
@Serializable
data class WanResponse<out T>(val data: T, val errorCode: Int, val errorMsg: String)