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
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

//@Composable
//fun DetailsScreen(
//                  posterId: Long,
//                  viewModel: DetailsViewModel,
//                  pressOnBack: () -> Unit
//) {
//    val movie: TopMovies? by viewModel.movieFlow.collectAsState(initial = null)
//
//    LaunchedEffect(key1 = posterId) {
//        viewModel.fetchMovieDetailsById(posterId)
//    }
//
//    Column(
//        modifier = Modifier
//            .verticalScroll(rememberScrollState())
//            .background(background)
//            .fillMaxSize(),
//    ) {
//
//        AppBarWithArrow(movie?.nameRu, pressOnBack)
//
//        MovieDetailHeader(viewModel)
//
//        MovieDetailSummary(viewModel)
//
//        MovieDetailReviews(viewModel)
//
//        Spacer(modifier = Modifier.height(24.dp))
//    }
//}
//
//@Composable
//private fun MovieDetailHeader(
//    viewModel: DetailsViewModel
//) {
//    val movie: TopMovies? by viewModel.movieFlow.collectAsState(initial = null)
//
//    Column {
//
//        var palette by remember { mutableStateOf<Palette?>(null) }
//        NetworkImage(
//            networkUrl = Api.getBackdropPath(movie?.backdrop_path),
//            circularReveal = CircularReveal(duration = 300),
//            shimmerParams = null,
//            bitmapPalette = BitmapPalette {
//                palette = it
//            },
//            modifier = Modifier
//                .height(280.dp)
//        )
//
//        Spacer(modifier = Modifier.height(25.dp))
//
//        Text(
//            text = movie?.title ?: "",
//            style = MaterialTheme.typography.h5,
//            color = Color.White,
//            textAlign = TextAlign.Center,
//            maxLines = 2,
//            overflow = TextOverflow.Ellipsis,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 8.dp)
//        )
//
//        Spacer(modifier = Modifier.height(6.dp))
//
//        Text(
//            text = "Release Date: ${movie?.release_date}",
//            style = MaterialTheme.typography.body1,
//            color = Color.White,
//            textAlign = TextAlign.Center,
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 8.dp)
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        RatingBar(
//            rating = (movie?.vote_average ?: 0f) / 2f,
//            color = Color(palette?.vibrantSwatch?.rgb ?: 0),
//            modifier = Modifier
//                .height(15.dp)
//                .align(Alignment.CenterHorizontally)
//        )
//    }
//}


@Composable
fun DetailsScreen() {

    val detailsViewModel = hiltViewModel<DetailsViewModel>()
    val detailsState = detailsViewModel.detailsState.collectAsState().value

    val backDropImageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(detailsState.movie?.posterUrl)
            .size(Size.ORIGINAL)
            .build()
    ).state

    val posterImageState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(detailsState.movie?.posterUrl)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        if (backDropImageState is AsyncImagePainter.State.Error) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(70.dp),
                    imageVector = Icons.Rounded.ImageNotSupported,
                    contentDescription = detailsState.movie?.nameRu
                )
            }
        }

        if (backDropImageState is AsyncImagePainter.State.Success) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                painter = backDropImageState.painter,
                contentDescription = detailsState.movie?.nameRu,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(240.dp)
            ) {
                if (posterImageState is AsyncImagePainter.State.Error) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(70.dp),
                            imageVector = Icons.Rounded.ImageNotSupported,
                            contentDescription = detailsState.movie?.nameRu
                        )
                    }
                }

                if (posterImageState is AsyncImagePainter.State.Success) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(12.dp)),
                        painter = posterImageState.painter,
                        contentDescription = detailsState.movie?.nameRu,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            detailsState.movie?.let { movie ->
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = movie.nameRu,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(16.dp))


//                    Text(
//                        modifier = Modifier.padding(start = 16.dp),
//                        text = movie.
//                    )
                }
            }
        }

//        Text(
//            modifier = Modifier.padding(start = 16.dp),
//            text = stringResource(R.string.overview),
//            fontSize = 19.sp,
//            fontWeight = FontWeight.SemiBold
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))

//        detailsState.movie?.let {
//            Text(
//                modifier = Modifier.padding(start = 16.dp),
//                text = it.overview,
//                fontSize = 16.sp,
//            )
//        }

    }

}