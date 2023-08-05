package com.ahmet.bostanciklioglu.multiplatform_movieapp.android

import android.app.Application
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.di.appModule
import com.ahmet.bostanciklioglu.multiplatform_movieapp.di.getSharedModules
import org.koin.core.context.startKoin

class Movie : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}