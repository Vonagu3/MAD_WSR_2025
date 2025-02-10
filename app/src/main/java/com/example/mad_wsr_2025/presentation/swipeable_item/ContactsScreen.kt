package com.example.mad_wsr_2025.presentation.swipeable_item

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ContactsScreen() {
    val context = LocalContext.current
    val contacts = remember {
        mutableStateListOf(
            *(0..100).map {
                ContactUi(
                    id = it,
                    name = "Contact $it",
                    isOptionsRevealed = false
                )
            }.toTypedArray()
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(
            items = contacts
        ) { index, _ ->
            SwipeableItemWithActions(
                isRevealed = contacts[index].isOptionsRevealed,
                onExpanded = {
                    contacts[index] = contacts[index].copy(isOptionsRevealed = true)
                },
                onCollapsed = {
                    contacts[index] = contacts[index].copy(isOptionsRevealed = false)
                },
                actions = {
                    ActionIcon(
                        onClick = {
                            contacts.remove(contacts[index])
                            Toast.makeText(
                                context,
                                "Contact ${contacts[index].id} was deleted",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Red,
                        icon = Icons.Default.Delete,
                        modifier = Modifier.fillMaxHeight()
                    )
                    ActionIcon(
                        onClick = {
                            contacts[index] = contacts[index].copy(isOptionsRevealed = false)
                            Toast.makeText(
                                context,
                                "Contact ${contacts[index].id} was sent as email",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Yellow,
                        icon = Icons.Default.Email,
                        modifier = Modifier.fillMaxHeight()
                    )
                    ActionIcon(
                        onClick = {
                            contacts[index] = contacts[index].copy(isOptionsRevealed = false)
                            Toast.makeText(
                                context,
                                "Contact ${contacts[index].id} was shared",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Magenta,
                        icon = Icons.Default.Share,
                        modifier = Modifier.fillMaxHeight()
                    )
                }
            ) {
                Text(
                    text = "Contact ${contacts[index].id}",
                    modifier = Modifier.padding(9.dp)
                )
            }
        }
    }
}