package com.ijays.gomvvm

import android.app.Application
import com.ijays.gomvvm.di.AppInjector

/**
 * Created by ijays on 2020/4/2.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Init DI
        AppInjector.init(this)

    }
}