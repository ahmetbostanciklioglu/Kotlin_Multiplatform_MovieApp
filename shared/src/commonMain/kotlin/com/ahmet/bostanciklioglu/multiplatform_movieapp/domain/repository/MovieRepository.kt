package com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.repository

import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: Int): Movie
}