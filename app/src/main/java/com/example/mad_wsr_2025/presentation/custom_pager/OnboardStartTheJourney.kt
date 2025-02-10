package com.example.sneakershopwsr.onboard.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mad_wsr_2025.R


@Composable
fun OnboardStartTheJourney() {
    Image(
        painter = painterResource(R.drawable.onboarding_1),
        contentDescription = null,
        modifier = Modifier
            .rotate(160f)
            .requiredSize(500.dp)
            .scale(1f, -1f),
    )

}