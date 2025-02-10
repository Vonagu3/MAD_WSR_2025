package com.example.mad_wsr_2025.presentation.otp

sealed interface OtpAction {
    data class OnEnterNumber(val number: Int?, val index: Int): OtpAction
    data class OnChangeFieldFocused(val index: Int): OtpAction
    data object OnKeyboardBack: OtpAction
}