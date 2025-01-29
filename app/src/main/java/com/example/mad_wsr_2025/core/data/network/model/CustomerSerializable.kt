package com.example.mad_wsr_2025.core.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CustomerSerializable(
    val id: Int? = null,
    val name: String
)
