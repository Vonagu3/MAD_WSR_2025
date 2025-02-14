package com.example.mad_wsr_2025.presentation.otp

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun OtpRoot(
    modifier: Modifier = Modifier,
    viewModel: Otp2ViewModel = hiltViewModel()
) {
    Otp(
        modifier = modifier,
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
fun Otp(
    modifier: Modifier = Modifier,
    state: Otp2State,
    onAction: (Otp2Action) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        BasicTextField(
            state = state.code,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            decorator = {
                Row(horizontalArrangement = Arrangement.Center) {
                    repeat(6) { index ->
                        val char = when {
                            index >= state.code.text.length -> ""
                            else -> state.code.text[index].toString()
                        }
                        val isFocused = state.code.text.length == index
                        Text(
                            modifier = Modifier
                                .width(40.dp)
                                .border(
                                    width = if (isFocused) 2.dp else 1.dp,
                                    color = if (isFocused) Color.DarkGray else Color.LightGray,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(2.dp),
                            text = char,
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.DarkGray,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        )
    }
    state.isEmailVerified?.let { isEmailVerified ->
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                dismissOnClickOutside = true
            )
        ) {
            Card(
                modifier = Modifier
                    .clickable { }
                    .height(100.dp)
                    .width(200.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                if (isEmailVerified) {
                    Text("Тут надо будет придумать пароль")
                } else {
                    Text("Неправильный OTP")
                }
            }
        }
    }
}