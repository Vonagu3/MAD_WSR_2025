package com.example.mad_wsr_2025

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.mad_wsr_2025.ui.theme.Accent
import com.example.mad_wsr_2025.ui.theme.Disable

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    content: @Composable (page: Int) -> Unit
) {
    val pagerState = rememberPagerState{ 3 }
    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Accent, Disable)
                        )
                    )
            ) {
                content.invoke(page)
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(end = 16.dp, bottom = 16.dp)
        ) {
            CustomPagerIndicatorSolution(
                pagerState = pagerState
            )
        }
    }
}