package com.ahmet.bostanciklioglu.multiplatform_movieapp.android.di

import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.detail.DetailViewModel
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}