package com.example.mad_wsr_2025

sealed interface SupabaseTestAction {
    data class OnAddNewCustomer(val name: String): SupabaseTestAction
}