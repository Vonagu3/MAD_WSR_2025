package com.example.mad_wsr_2025.presentation.custom_pager

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingScreen2ViewModel @Inject constructor(): ViewModel() {
    var targetState by mutableStateOf("0")
    val lastPageNumber = "2"

    fun onLeftSwipe() {
        if (targetState.toInt() > 0)
//            targetState = targetState.copy(step = targetState.step - 1)
            targetState = (targetState.toInt() - 1).toString()
    }

    fun onRightSwipe() {
        if (targetState < lastPageNumber)
//            targetState = targetState.copy(step = targetState.step + 1)
            targetState = (targetState.toInt() + 1).toString()
    }
}