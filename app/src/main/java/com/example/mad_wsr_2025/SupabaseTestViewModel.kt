package com.example.mad_wsr_2025

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mad_wsr_2025.domain.SupabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SupabaseTestViewModel @Inject constructor(
    private val repository: SupabaseRepository
) : ViewModel() {

    var state by mutableStateOf(SupabaseTestState())
        private set

    init {
        viewModelScope.launch {
            getCustomers()
        }
//        repository.getCustomers().onEach { customers ->
//            state = state.copy(
//                customers = customers
//            )
//        }.launchIn(viewModelScope)
    }

    private fun addCustomer(name: String) {
        viewModelScope.launch {
            repository.addCustomer(name)
            getCustomers()
        }
    }

    private suspend fun getCustomers() {
        state = state.copy(customers = repository.getCustomers())
    }

    fun onAction(action: SupabaseTestAction) {
        when(action) {
            is SupabaseTestAction.OnAddNewCustomer -> addCustomer(action.name)
        }
    }
}