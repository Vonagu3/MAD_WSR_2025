package com.example.mad_wsr_2025.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mad_wsr_2025.presentation.otp.OtpScreen2

@Composable
fun LoginScreen(
    viewModel: LoginScreenViewModel = hiltViewModel()
) {
    val emailText = remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = emailText.value,
                onValueChange = { emailText.value = it },
                label = {
                    Text("Введите email:")
                }
            )
            Button(
                onClick = {
                    viewModel.signIn(email = emailText.value)
                }
            ) {
                Text("Отправить OTP код")
            }
            if (viewModel.state.isSuccessful == true) {
                OtpScreen2(
                    onOtpVerification = { otp ->
                        viewModel.verifyOtp(
                            email = emailText.value,
                            otp = otp
                        )
                    }
                )
            }
        }
        if (viewModel.state.isEmailVerified == true) {
            Dialog(
                onDismissRequest = {},
                properties = DialogProperties(
                    dismissOnClickOutside = true
                )
            ) {
                Card(
                    modifier = Modifier
                        .height(100.dp)
                        .width(200.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Тут надо будет ввести фразу для генерации нового пароля")
                }
            }
        }
    }
}