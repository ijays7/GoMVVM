package com.ijays.gomvvm.di

import com.ijays.gomvvm.App
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Helper class to create an abstraction layer over the DI technique used in the app
 *
 * Created by ijays on 2020/4/2.
 */
object AppInjector {

    private val declaredModules = listOf(repositoryModule, viewModelModule)

    /**
     * Initialize Koin
     */
    fun init(app: App) {
        startKoin {
            // use Koin Android Logger
            androidLogger()
            // declare Android context
            androidContext(app)
            // declare modules to use
            modules(declaredModules)
        }
    }

}