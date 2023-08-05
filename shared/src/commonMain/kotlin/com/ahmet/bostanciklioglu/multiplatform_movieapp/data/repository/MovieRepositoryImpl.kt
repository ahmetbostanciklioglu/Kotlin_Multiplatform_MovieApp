package com.ahmet.bostanciklioglu.multiplatform_movieapp.data.repository

import com.ahmet.bostanciklioglu.multiplatform_movieapp.data.remote.RemoteDataSource
import com.ahmet.bostanciklioglu.multiplatform_movieapp.data.util.toMovie
import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.model.Movie
import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}