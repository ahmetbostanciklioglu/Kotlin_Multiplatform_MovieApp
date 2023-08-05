package com.ahmet.bostanciklioglu.multiplatform_movieapp.android.detail

import com.ahmet.bostanciklioglu.multiplatform_movieapp.domain.model.Movie

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)
