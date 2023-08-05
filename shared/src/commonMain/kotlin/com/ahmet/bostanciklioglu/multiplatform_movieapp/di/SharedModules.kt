package com.ahmet.bostanciklioglu.multiplatform_movieapp.di

import com.ahmet.bostanciklioglu.multiplatform_movieapp.data.remote.MovieService
import com.ahmet.bostanciklioglu.multiplatform_movieapp.data.remote.RemoteDataSource
import com.ahmet.bostanciklioglu.multiplatform_movieapp.data.repository.MovieRepositoryImpl
import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.repository.MovieRepository
import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.usecase.GetMovieUseCase
import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.usecase.GetMoviesUseCase
import com.ahmet.bostanciklioglu.multiplatform_movieapp.util.provideDispatcher
import org.koin.dsl.module


private val dataModule = module {
    factory {
        RemoteDataSource(get(), get())
    }
    factory {
        MovieService()
    }
}
private val utilityModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
    factory {
        GetMoviesUseCase()
    }
    factory {
        GetMovieUseCase()
    }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules