package com.tymora.beletskaya_moviesapp.listMovies.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tymora.beletskaya_moviesapp.listMovies.details.DetailsViewModel
import com.tymora.beletskaya_moviesapp.listMovies.domain.model.TopMovies

@Composable
fun DetailsScreen(
                  posterId: Long,
                  viewModel: DetailsViewModel,
                  pressOnBack: () -> Unit
) {
    val movie: TopMovies? by viewModel.movieFlow.collectAsState(initial = null)

    LaunchedEffect(key1 = posterId) {
        viewModel.fetchMovieDetailsById(posterId)
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(background)
            .fillMaxSize(),
    ) {

        AppBarWithArrow(movie?.nameRu, pressOnBack)

        MovieDetailHeader(viewModel)

        MovieDetailSummary(viewModel)

        MovieDetailReviews(viewModel)

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun MovieDetailHeader(
    viewModel: DetailsViewModel
) {
    val movie: TopMovies? by viewModel.movieFlow.collectAsState(initial = null)

    Column {

        var palette by remember { mutableStateOf<Palette?>(null) }
        NetworkImage(
            networkUrl = Api.getBackdropPath(movie?.backdrop_path),
            circularReveal = CircularReveal(duration = 300),
            shimmerParams = null,
            bitmapPalette = BitmapPalette {
                palette = it
            },
            modifier = Modifier
                .height(280.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = movie?.title ?: "",
            style = MaterialTheme.typography.h5,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Release Date: ${movie?.release_date}",
            style = MaterialTheme.typography.body1,
            color = Color.White,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        RatingBar(
            rating = (movie?.vote_average ?: 0f) / 2f,
            color = Color(palette?.vibrantSwatch?.rgb ?: 0),
            modifier = Modifier
                .height(15.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}