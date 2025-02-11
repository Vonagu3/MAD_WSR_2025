package com.example.mad_wsr_2025

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Immutable
import com.example.mad_wsr_2025.domain.Customer
import com.example.mad_wsr_2025.domain.ProductInfo

@Immutable
data class SupabaseTestState(
    val newCustomerState: TextFieldState = TextFieldState(),
    val customers: List<Customer> = emptyList(),
    val products: List<ProductInfo> = emptyList()
)
