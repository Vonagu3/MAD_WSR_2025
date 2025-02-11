package com.example.mad_wsr_2025.core.data.network

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.ktor.client.plugins.logging.Logger

class SupabaseClientFactory {
    fun build(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://vqnoqoxdnwncnvbndmjj.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZxbm9xb3hkbnduY252Ym5kbWpqIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzgwODE5MjMsImV4cCI6MjA1MzY1NzkyM30.TVHZp0SrBdxdGgRJlFTeMngffCDLmhIhvC9fAPrhB6o"
        ) {
            install(Postgrest)
            install(Auth)
        }
    }
}