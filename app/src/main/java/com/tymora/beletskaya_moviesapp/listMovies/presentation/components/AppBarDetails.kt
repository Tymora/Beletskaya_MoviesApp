//package com.tymora.beletskaya_moviesapp.listMovies.presentation.components
//
//import android.graphics.drawable.VectorDrawable
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.res.vectorResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.tymora.beletskaya_moviesapp.ui.theme.*
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBarDetails(
//    title: String?,
//    pressOnBack: () -> Unit
//) {
//    TopAppBar(
//        title = { Text(text = "")},
//        navigationIcon ={
//                        Icon(imageVector = ImageVector.vectorResource(id = res.drawable.toolbar), contentDescription ="" )
//        } ,
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            MaterialTheme.colorScheme.inverseOnSurface
//        ),
//        modifier = Modifier.height(58.dp)
//    ) {
//        Row {
//            Spacer(modifier = Modifier.width(10.dp))
//
//            Image(
//                imageVector = Icons.Filled.ArrowBack,
//                colorFilter = ColorFilter.tint(Color.White),
//                contentDescription = null,
//                modifier = Modifier
//                    .align(Alignment.CenterVertically)
//                    .clickable {
//                        pressOnBack()
//                    }
//            )
//
//            Spacer(modifier = Modifier.width(12.dp))
//
//            Text(
//                modifier = Modifier
//                    .padding(8.dp)
//                    .align(Alignment.CenterVertically),
//                text = title ?: "",
//                color = Color.White,
//                fontSize = 18.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
//}
