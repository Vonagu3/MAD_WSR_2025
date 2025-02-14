package com.example.mad_wsr_2025.presentation.otp

import androidx.compose.foundation.text.input.TextFieldState

data class Otp2State(
    val code: TextFieldState = TextFieldState(),
    val isEmailVerified: Boolean? = null
)
