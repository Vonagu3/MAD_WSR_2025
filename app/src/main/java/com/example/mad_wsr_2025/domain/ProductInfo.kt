package com.example.mad_wsr_2025.domain

data class ProductInfo(
    val id: Int,
    val name: String,
    val price: Float,
    val description: String?,
    val images: List<String>,
    val categoryId: Int,
)