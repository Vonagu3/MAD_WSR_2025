package com.example.mad_wsr_2025.presentation.custom_pager

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import com.example.mad_wsr_2025.R
import com.example.mad_wsr_2025.ui.theme.Accent
import com.example.mad_wsr_2025.ui.theme.Disable

@Composable
fun OnboardingScreen2(
    modifier: Modifier = Modifier,
) {
    var state by remember { mutableStateOf(PagerState(0)) }
    val buttonText = listOf("Начать", "Далее", "Далее")
    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectSwipe(
                    onSwipeLeft = {
                        if (state.step < 2) {
                            state = state.copy(step = state.step + 1)
                        }
                    },
                    onSwipeRight = {
                        if (state.step > 0) {
                            state = state.copy(step = state.step - 1)
                        }
                    }
                )
            }
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Accent, Disable)
                )
            )
    ) {

        AnimatedContent(
            targetState = state,
            label = "",
            transitionSpec = {
                fadeIn(animationSpec = tween(300, 150)) togetherWith fadeOut(animationSpec = tween(300, 150))
            }
        ) { state ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                painter = when (state.step) {
                    0 -> painterResource(R.drawable.onboarding_1)
                    1 -> painterResource(R.drawable.onboarding_2)
                    2 -> painterResource(R.drawable.onboarding_3)
                    else -> painterResource(R.drawable.onboarding_3)
                },
                contentDescription = null
            )

        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(fraction = 0.8f),
            onClick = {
                state = state.copy(step = state.step + 1)
            }
        ) {
            Text(text = buttonText[state.step % buttonText.size])
        }
    }
}

suspend fun PointerInputScope.detectSwipe(
    swipeState: MutableIntState = mutableIntStateOf(-1),
    onSwipeLeft: () -> Unit = {},
    onSwipeRight: () -> Unit = {}
) = detectHorizontalDragGestures(
    onHorizontalDrag = { _, x ->
        when {
            x > 0 -> swipeState.intValue = 0
            x < 0 -> swipeState.intValue = 1
        }
    },
    onDragEnd = {
        when (swipeState.intValue) {
            0 -> onSwipeRight()
            1 -> onSwipeLeft()
        }
    }
)
//    detectDragGestures(
//    onDrag = { change, dragAmount ->
//        change.consume()
//        val (x, y) = dragAmount
//            when {
//                x > 0 -> swipeState.intValue = 0
//                x < 0 -> swipeState.intValue = 1
//            }
//    },
//    onDragEnd = {
//        when (swipeState.intValue) {
//            0 -> onSwipeRight()
//            1 -> onSwipeLeft()
//        }
//    }
//)