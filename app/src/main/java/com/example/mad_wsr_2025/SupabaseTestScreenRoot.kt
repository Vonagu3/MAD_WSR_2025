package com.example.mad_wsr_2025

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SupabaseTestScreenRoot(
    viewModel: SupabaseTestViewModel = hiltViewModel(),
) {
    SupabaseTestScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center
//    ){
////        Text("SupabaseScreen")
//
//        viewModel.state.customers.forEach { customer ->
//            Text(customer.name)
//        }
//    }
}

@Composable
fun SupabaseTestScreen(
    state: SupabaseTestState,
    onAction: (SupabaseTestAction) -> Unit
) {
    LazyColumn {
        item {
            Text(text = "Список покупателей")
        }
        item {
            BasicTextField(state = state.newCustomerState)
        }
        item {
            Button(
                onClick = { onAction(SupabaseTestAction.OnAddNewCustomer(state.newCustomerState.text.toString())) }
            ) {
                Text("Добавить")
            }
        }
        items(state.customers) { customer ->
            Text(customer.name)
        }
    }
}

