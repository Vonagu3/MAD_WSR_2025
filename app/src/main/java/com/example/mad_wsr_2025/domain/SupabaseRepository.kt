package com.example.mad_wsr_2025.domain

import kotlinx.coroutines.flow.Flow

interface SupabaseRepository {
    suspend fun getCustomers(): List<Customer>
    suspend fun addCustomer(name: String)
    suspend fun getProduct(): List<ProductInfo>
}