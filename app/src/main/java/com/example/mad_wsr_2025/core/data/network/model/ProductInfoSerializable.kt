package com.example.mad_wsr_2025.core.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductInfoSerializable(
    val id: Int,
    val name: String,
    val price: Float,
    val description: String?,
    val images: List<String>,
    @SerialName("category_id")
    val categoryId: Int,
)