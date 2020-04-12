package com.ijays.gomvvm.di

import com.ijays.gomvvm.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by ijays on 2020/4/12.
 */
val articleDatabaseModule = module {

    single {
        AppDatabase.buildDefault(androidApplication())
    }

    single {
        get<AppDatabase>().articleDao()
    }
}