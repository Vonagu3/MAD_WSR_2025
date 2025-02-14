package com.example.mad_wsr_2025.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TestCoil() {
//    val painter = rememberAsyncImagePainter("https://eqlghtbaclnlalqtwbrp.supabase.co/storage/v1/object/public/sneaker_images/Nike%20Air%20Max.png")
//    val painter = rememberImagePainter
//    Image(
//        modifier = Modifier.fillMaxSize(),
//        painter = painter,
//        contentDescription = null
//    )
    Box {
        AsyncImage(
            model = "https://eqlghtbaclnlalqtwbrp.supabase.co/storage/v1/object/public/sneaker_images/Nike%20Air%20Max.png",
//            model = "https://cdn.sstatic.net/Img/teams/teams-promo.svg?v=e507948b81bf",
            contentDescription = null,
//            modifier = Modifier.size(200.dp, 200.dp)
        )
//        GlideImage(
//            model = "https://eqlghtbaclnlalqtwbrp.supabase.co/storage/v1/object/public/sneaker_images/Nike%20Air%20Max.png",
//            contentDescription = null,
//        )
    }
}