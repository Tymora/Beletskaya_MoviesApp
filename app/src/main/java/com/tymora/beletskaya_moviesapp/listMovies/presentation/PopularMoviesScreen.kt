package com.tymora.beletskaya_moviesapp.listMovies.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tymora.beletskaya_moviesapp.listMovies.presentation.components.MovieItem
import com.tymora.beletskaya_moviesapp.listMovies.utill.Category

@Composable
fun PopularMoviesScreen(
    movieListState: MovieListState,
    navController: NavHostController,
    onEvent: (MovieListUiEvent) -> Unit
) {

    if (movieListState.popularTopMoviesList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(movieListState.popularTopMoviesList.size) { index ->
                MovieItem(
                    topMovies = movieListState.popularTopMoviesList[index],
                    navHostController = navController
                )

                if (index >= movieListState.popularTopMoviesList.size - 1 && !movieListState.isLoading) {
                    onEvent(MovieListUiEvent.Paginate(Category.POPULAR))
                }

            }
        }
    }

}
