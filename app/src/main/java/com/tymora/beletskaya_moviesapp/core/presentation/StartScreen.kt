package com.tymora.beletskaya_moviesapp.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tymora.beletskaya_moviesapp.R
import com.tymora.beletskaya_moviesapp.listMovies.presentation.MovieListUiEvent
import com.tymora.beletskaya_moviesapp.listMovies.presentation.MovieListViewModel
import com.tymora.beletskaya_moviesapp.listMovies.utill.Screen
import com.tymora.beletskaya_moviesapp.listMovies.presentation.PopularMoviesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(navController: NavHostController) {

    val movieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieListState = movieListViewModel.movieListState.collectAsState().value
    val bottomNavController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigationBar(
            bottomNavController = bottomNavController, onEvent = movieListViewModel::onEvent
        )
    }, topBar = {
        TopAppBar(
            title = {
                Text(
                    text = if (movieListState.isCurrentPopularScreen)
                        stringResource(R.string.popular_movies)
                    else
                        stringResource(R.string.favorite_movie),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 33.sp
                )
            },
            modifier = Modifier.shadow(2.dp),
            colors = TopAppBarDefaults.topAppBarColors(
                MaterialTheme.colorScheme.inverseOnSurface
            )
        )
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(
                navController = bottomNavController,
                startDestination = Screen.PopularMovieList.rout
            ) {
                composable(Screen.PopularMovieList.rout) {
                    PopularMoviesScreen(
                        navController = navController,
                        movieListState = movieListState,
                        onEvent = movieListViewModel::onEvent
                    )
                }
                composable(Screen.FavoriteMovieList.rout) {
//                    FavoriteMoviesScreen()
                }
            }
        }
    }

}


@Composable
fun BottomNavigationBar(
    bottomNavController: NavHostController, onEvent: (MovieListUiEvent) -> Unit
) {

    val items = listOf(
        BottomItem(
            title = stringResource(R.string.popular_movies),
        ), BottomItem(
            title = stringResource(R.string.favorite_movie),
        )
    )

    val selected = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface)
        ) {
            items.forEachIndexed { index, bottomItem ->
                NavigationBarItem(selected = selected.intValue == index, onClick = {
                    selected.intValue = index
                    when (selected.intValue) {
                        0 -> {
                            onEvent(MovieListUiEvent.Navigate)
                            bottomNavController.popBackStack()
                            bottomNavController.navigate(Screen.PopularMovieList.rout)
                        }

                        1 -> {
                            onEvent(MovieListUiEvent.Navigate)
                            bottomNavController.popBackStack()
                            bottomNavController.navigate(Screen.FavoriteMovieList.rout)
                        }
                    }
                }, icon = {
                }, label = {
                    Text(
                        text = bottomItem.title,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 19.sp
                    )
                })
            }
        }
    }
}

data class BottomItem(
    val title: String
)