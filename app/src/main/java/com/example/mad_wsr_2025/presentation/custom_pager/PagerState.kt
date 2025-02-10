package com.example.mad_wsr_2025.presentation.custom_pager

enum class OnboardingScreenStep {
    FIRST_STEP,
    SECOND_STEP,
    THIRD_STEP
}



data class PagerState(
    val step: Int = 0
)
