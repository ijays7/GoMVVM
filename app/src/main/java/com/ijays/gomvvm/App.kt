package com.ijays.gomvvm

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by ijays on 2020/4/2.
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Init DoraemonKit
        DoraemonKit.install(this)
    }
}