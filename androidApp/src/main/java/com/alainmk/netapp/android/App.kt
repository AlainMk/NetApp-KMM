package com.alainmk.netapp.android

import android.app.Application
import com.alainmk.netapp.android.di.androidAppModule
import com.alainmk.netapp.di.initKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            modules(androidAppModule)
        }
    }
}