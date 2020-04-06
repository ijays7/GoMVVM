package com.ijays.gomvvm.model.base

/**
 * base model
 *
 * Created by ijays on 2020/4/5.
 */
data class WanResponse<out T>(val data: T, val errorCode: Int, val errorMsg: String)