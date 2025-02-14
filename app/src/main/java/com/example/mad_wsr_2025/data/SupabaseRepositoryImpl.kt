package com.example.mad_wsr_2025.data

import android.util.Log
import com.example.mad_wsr_2025.core.data.network.model.CustomerSerializable
import com.example.mad_wsr_2025.core.data.network.model.ProductInfoSerializable
//import com.example.mad_wsr_2025.core.data.network.toCustomer
import com.example.mad_wsr_2025.core.data.network.toProductInfo
import com.example.mad_wsr_2025.domain.Customer
import com.example.mad_wsr_2025.domain.ProductInfo
import com.example.mad_wsr_2025.domain.SupabaseRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.OtpType
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.exception.AuthRestException
import io.github.jan.supabase.auth.providers.builtin.OTP
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.RestException
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SupabaseRepositoryImpl(
    private val supabaseClient: SupabaseClient
) : SupabaseRepository {
    override suspend fun getCustomers(): List<Customer> = emptyList()
//        withContext(Dispatchers.IO) {
//        supabaseClient.from(CUSTOMER_TABLE).select().decodeList<CustomerSerializable>()
//            .map { it.toCustomer() }
//    }

    override suspend fun addCustomer(name: String) {
        withContext(Dispatchers.IO) {
            val customer = CustomerSerializable(id = 5, name = name)
            val result = supabaseClient.from(CUSTOMER_TABLE).insert(customer)
            val data = result.data
            println(data)
        }
    }

    override suspend fun getProduct(): List<ProductInfo> = withContext(Dispatchers.IO) {
        supabaseClient.from(PRODUCT_TABLE).select().decodeList<ProductInfoSerializable>()
            .map { it.toProductInfo() }
    }

    override suspend fun signIn(email: String): Boolean {
        try {
            supabaseClient.auth.signInWith(OTP) {
                this.email = email
            }
            return true
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
            return false
        }
    }

    override suspend fun verifyOtp(email: String, otp: String): Boolean {
        try {
            supabaseClient.auth.verifyEmailOtp(
                type = OtpType.Email.EMAIL,
                email = email,
                token = otp
            )
            return true
        } catch (e: Exception) {
            Log.d("ERROR", e.message.toString())
            return false
        }
    }


    override suspend fun getProductsInfo(count: Long?): List<ProductInfo> =
        withContext(Dispatchers.IO) {
            supabaseClient.from(PRODUCT_TABLE).select {
                if (count !== null) limit(count = count)
            }.decodeList<ProductInfoSerializable>().map { it.toProductInfo() }

        }

    private companion object {
        const val CUSTOMER_TABLE = "Customer"
        const val PRODUCT_TABLE = "Product"
    }
}