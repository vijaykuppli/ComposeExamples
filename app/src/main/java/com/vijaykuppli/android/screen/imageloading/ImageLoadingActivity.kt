package com.vijaykuppli.android.screen.imageloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.vijaykuppli.android.R

class ImageLoadingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            CoilNetworkImageLoading()
//            CoilNetworkErrorHandlingImageLoading()
            CoilImageLoadingUsingSubComposeAsyncImage()
        }
    }
}

@Composable
fun CoilNetworkImageLoading() {
    /**
     * Coil network image loading
     */
    AsyncImage(
        model = "https://picsum.photos/200",
        contentDescription = "sample image"
    )
}

@Composable
fun CoilNetworkErrorHandlingImageLoading() {
    /**
     * Coil network error handling image loading
     */
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("https://picsum.photos/200")
            .crossfade(true)
            .build(),
        contentDescription = "sample image",
        error = painterResource(R.drawable.search),
        placeholder = painterResource(R.drawable.coil)
    )
}

@Composable
fun CoilImageLoadingUsingSubComposeAsyncImage() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
    SubcomposeAsyncImage(model = ImageRequest.Builder(LocalContext.current)
        .data("https://picsum.photos/200")
        .crossfade(true)
        .build(),
        contentDescription = "sample image",
        loading = {
            CircularProgressIndicator(
                color = ProgressIndicatorDefaults.linearColor,
                strokeWidth = 10.dp,
                strokeCap = StrokeCap.Round
            )
        }
    )
        }
}