package com.ahmet.bostanciklioglu.multiplatform_movieapp.data.remote

import com.ahmet.bostanciklioglu.multiplatform_movieapp.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId = movieId)
    }
}