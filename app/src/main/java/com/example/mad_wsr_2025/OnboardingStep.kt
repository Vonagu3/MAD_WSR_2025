package com.example.mad_wsr_2025

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun OnboardingStep(page: Int) {
    Text(
        text = "$page",
        modifier = Modifier
    )
}