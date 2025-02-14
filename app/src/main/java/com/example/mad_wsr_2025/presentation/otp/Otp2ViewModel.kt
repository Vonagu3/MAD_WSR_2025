package com.example.mad_wsr_2025.presentation.otp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.mad_wsr_2025.OTP
import com.example.mad_wsr_2025.domain.SupabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Otp2ViewModel @Inject constructor(
    private val repository: SupabaseRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(Otp2State())
        private set

    init {
        val email = savedStateHandle.toRoute<OTP>().email
        snapshotFlow { state.code.text }
            .onEach { code ->
                if (code.length == 6) {
                    val res = repository.verifyOtp(email = email, otp = code.toString())
                    state = state.copy(
                        isEmailVerified = res
                    )
                }
            }.launchIn(viewModelScope)
    }

    fun onAction(action: Otp2Action) {

    }
}