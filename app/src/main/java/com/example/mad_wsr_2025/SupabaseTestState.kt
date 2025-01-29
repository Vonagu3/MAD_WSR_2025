package com.example.mad_wsr_2025

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Immutable
import com.example.mad_wsr_2025.domain.Customer

@Immutable
data class SupabaseTestState(
    val newCustomerState: TextFieldState = TextFieldState(),
    val customers: List<Customer> = emptyList()
)
