package com.example.mad_wsr_2025.data

import com.example.mad_wsr_2025.core.data.network.model.CustomerSerializable
import com.example.mad_wsr_2025.core.data.network.toCustomer
import com.example.mad_wsr_2025.domain.Customer
import com.example.mad_wsr_2025.domain.SupabaseRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SupabaseRepositoryImpl(
    private val supabaseClient: SupabaseClient
) : SupabaseRepository {
    override suspend fun getCustomers(): List<Customer> = withContext(Dispatchers.IO) {
        supabaseClient.from(CUSTOMER_TABLE).select().decodeList<CustomerSerializable>()
            .map { it.toCustomer() }
    }

    override suspend fun addCustomer(name: String) {
        withContext(Dispatchers.IO) {
            val customer = CustomerSerializable(id = 5, name = name)
            val result = supabaseClient.from(CUSTOMER_TABLE).insert(customer)
            val data = result.data
            println(data)
        }
    }

    private companion object {
        const val CUSTOMER_TABLE = "Customer"
    }
}