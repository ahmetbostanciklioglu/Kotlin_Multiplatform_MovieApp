package com.ahmet.bostanciklioglu.multiplatform_movieapp.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.common.Detail
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.common.Home
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.common.MovieAppBar
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.common.movieDestinations
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.detail.DetailScreen
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.detail.DetailViewModel
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.home.HomeScreen
import com.ahmet.bostanciklioglu.multiplatform_movieapp.android.home.HomeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf


@Composable
fun MovieApp() {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    val isSystemDark = isSystemInDarkTheme()
    val statusBarColor = if (isSystemDark) {
        MaterialTheme.colors.primaryVariant
    } else {
        Color.Transparent
    }

    SideEffect {
        systemUiController.setStatusBarColor(statusBarColor, darkIcons = !isSystemDark)
    }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find {
        backStackEntry?.destination?.route ==
                it.route || backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen
            ) {
                navController.navigateUp()
            }
        }
    ) { innerPaddings ->

        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPaddings),
            startDestination = Home.routeWithArgs
        ) {
            composable(route = Home.routeWithArgs) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    uiState = homeViewModel.uiState,
                    loadNextMovies = {
                        homeViewModel.loadMovies(forceReload = it)
                    },
                    navigateToDetail = {
                        navController.navigate(route = "${Detail.route}/${it.id}")
                    }
                )
            }

            composable(route = Detail.routeWithArgs) {
                val movieId = it.arguments?.getString("movieId") ?: "0"
                val detailViewModel: DetailViewModel = koinViewModel(
                    parameters = { parametersOf(movieId.toInt()) }
                )
                DetailScreen(uiState = detailViewModel.uiState)

            }
        }
    }
}