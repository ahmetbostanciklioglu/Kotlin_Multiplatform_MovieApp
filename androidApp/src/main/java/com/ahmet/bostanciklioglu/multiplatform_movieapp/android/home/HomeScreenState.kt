package com.ahmet.bostanciklioglu.multiplatform_movieapp.android.home

import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.model.Movie

data class HomeScreenState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<Movie> = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false
)