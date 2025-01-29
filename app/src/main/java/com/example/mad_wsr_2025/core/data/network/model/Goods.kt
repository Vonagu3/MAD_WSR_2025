package com.example.mad_wsr_2025.core.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Goods(
    val id: Int,
    val name: String,
    val customerId: Int
)
