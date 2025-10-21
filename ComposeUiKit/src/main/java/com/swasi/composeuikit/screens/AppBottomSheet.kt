package com.swasi.composeuikit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swasi.composeuikit.AppButton
import com.swasi.composeuikit.theme.Colors
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBaseBottomSheet(
    modifier: Modifier = Modifier,
    showBottomSheet: Boolean = true,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showSheet by remember { mutableStateOf(showBottomSheet) }
    val scope = rememberCoroutineScope()
    if (showSheet) {
        ModalBottomSheet(
            modifier = modifier,
            onDismissRequest = {
                scope.launch { sheetState.hide() }
                onDismiss()
            },
            sheetState = sheetState
        ) {
            content()
        }
    }
}

@Composable
fun ConfirmBottomSheetDialog(
    title: String = "Are you sure?",
    message: String = "Do you want to proceed with this action?",
    positiveButtonText: String = "Yes",
    negativeButtonText: String = "No",
    toolbarColor: Color = Colors.teal700,
    onPositiveActionClick: () -> Unit,
    onNegativeActionClick: () -> Unit
) {
    AppBaseBottomSheet(
        onDismiss = { onNegativeActionClick() }
    ) {
        Column(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = toolbarColor,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Colors.teal700)
                    .padding(5.dp),
                color = Colors.white,
                fontSize = 20.sp
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Colors.white),
            ) {
                Text(
                    text = message,
                    modifier = Modifier.padding(24.dp)
                )
                Row {
                    AppButton(
                        buttonText = positiveButtonText,
                        onClick = { onPositiveActionClick() },
                        modifier = Modifier.padding(16.dp)
                    )
                    AppButton(
                        buttonText = negativeButtonText,
                        onClick = { onNegativeActionClick() },
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ConfirmBottomSheetDialogPreview() {
    ConfirmBottomSheetDialog(
        onPositiveActionClick = {},
        onNegativeActionClick = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomSheetDemo(
    message: String,
    buttonText: String,
    onClose: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = { onClose }
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(24.dp)
        )
        AppButton(
            onClick = { onClose },
            modifier = Modifier.padding(16.dp),
            buttonText = buttonText
        )
    }
}

@Preview
@Composable
fun AppBottomSheetDemoPreview() {
    AppBottomSheetDemo(
        message = "This is a sample message for the bottom sheet.",
        buttonText = "Close",
        onClose = {}
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomSheetDemo() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showSheet = true }) {
                Text("Show Sheet")
            }
        }
    ) { padding ->
        if (showSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSheet = false },
                sheetState = sheetState
            ) {
                Text(
                    text = "This is a bottom sheet!",
                    modifier = Modifier.padding(24.dp)
                )
                Button(
                    onClick = {
                        scope.launch { sheetState.hide() }
                        showSheet = false
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Close")
                }
            }
        }
    }
}

@Preview
@Composable
fun AppBottomSheetDemoPreview2() {
    AppBottomSheetDemo()
}