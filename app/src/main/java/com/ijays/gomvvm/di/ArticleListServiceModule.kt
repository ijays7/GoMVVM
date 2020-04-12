package com.ijays.gomvvm.di

import com.ijays.gomvvm.model.api.ApiManager
import org.koin.dsl.module

/**
 * Created by ijays on 2020/4/6.
 */
val articleListServiceModule = module {
    single {
        ApiManager
    }
}
