package com.ahmet.bostanciklioglu.multiplatform_movieapp.util

import com.ahmet.bostanciklioglu.multiplatform_movieapp.di.getSharedModules
import org.koin.core.context.startKoin


fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}