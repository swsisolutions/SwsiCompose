package com.swasi.composeuikit.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppMultipleChoiceDialog(
    title: String,
    message: String,
    options: List<String>,
    initialSelected: List<String> = emptyList(),
    onConfirm: (List<String>) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedOptions by remember { mutableStateOf(initialSelected.toMutableSet()) }
    var listChoices by remember { mutableStateOf(options) }

    AlertDialog(
        onDismissRequest = onCancel,
        title = { Text(title) },
        text = {
            Column {
                Text(message)
                Spacer(Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier.heightIn(max = 240.dp)
                ) {
                    items(listChoices) { option ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Checkbox(
                                checked = selectedOptions.contains(option),
                                onCheckedChange = { checked ->
                                    if (checked) selectedOptions.add(option)
                                    else selectedOptions.remove(option)

                                    selectedOptions = selectedOptions.toMutableSet()
                                }
                            )
                            Text(option, modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirm(selectedOptions.toList()) }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onCancel) {
                Text("Cancel")
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun AppMultipleChoiceDialogPreview() {
    AppMultipleChoiceDialog(
        title = "Select Options",
        message = "Please select one or more options:",
        options = listOf("Option 1", "Option 2", "Option 3", "Option 4"),
        initialSelected = listOf("Option 2"),
        onConfirm = {},
        onCancel = {}
    )
}