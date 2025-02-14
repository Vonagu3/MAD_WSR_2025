package com.example.mad_wsr_2025.presentation.forgot_password

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mad_wsr_2025.domain.SupabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: SupabaseRepository
) : ViewModel() {

    var state by mutableStateOf(ForgotPasswordState())
        private set

    fun signIn(email: String) {
        viewModelScope.launch {
            state = state.copy(isSuccessful = repository.signIn(email))
        }
    }
}