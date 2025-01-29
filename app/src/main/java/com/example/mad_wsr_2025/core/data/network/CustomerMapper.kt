package com.example.mad_wsr_2025.core.data.network

import com.example.mad_wsr_2025.core.data.network.model.CustomerSerializable
import com.example.mad_wsr_2025.domain.Customer

fun Customer.toCustomerSerializable(): CustomerSerializable {
    return CustomerSerializable(
        id = id,
        name = name
    )
}

fun CustomerSerializable.toCustomer(): Customer {
    return Customer(
        id = id,
        name = name
    )
}