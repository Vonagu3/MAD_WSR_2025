package com.example.mad_wsr_2025

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun OnboardingSplashScreen(
    modifier: Modifier = Modifier,
    onNextScreen: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        onNextScreen.invoke()
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        // Change the logo
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.matule_me),
            contentDescription = "Logo")
    }
}