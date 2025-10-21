package com.swasi.composeuikit.screens

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swasi.composeuikit.R

@Composable
fun AppErrorScreen(
    title: String = "",
    message: String = "",
    errorDrawable: Int = 0,
    positiveButtonText: String = "",
    negativeButtonText: String = "",
    errorType: AppErrorType,
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit
) {
    when (errorType) {
        AppErrorType.NO_INTERNET -> {
            NoInternetScreen(
                onRetry = onPositiveButtonClick,
                showRetry = true,
                showSettings = true,
                isFullScreen = false
            )
        }

        AppErrorType.NO_INTERNET_FULLSCREEN -> {
            NoInternetScreen(
                onRetry = onPositiveButtonClick,
                showRetry = positiveButtonText.isNotEmpty(),
                showSettings = negativeButtonText.isNotEmpty()
            )
        }

        AppErrorType.SESSION_EXPIRED -> {
            // Render Session Expired Error Screen
        }

        AppErrorType.GENERIC_ERROR -> {
            GenericErrorScreen(
                title = title,
                message = message,
                errorDrawable = if (errorDrawable != 0) errorDrawable else R.drawable.error,
                positiveButtonText = positiveButtonText.ifEmpty { "Okay" },
                negativeButtonText = negativeButtonText,
                onPositiveButtonClick = onPositiveButtonClick,
                onNegativeButtonClick = onNegativeButtonClick,
                isFullScreen = false
            )
        }

        AppErrorType.FULLSCREEN_ERROR -> {
            // Render Fullscreen Generic Error Screen
        }

        AppErrorType.WARNING -> {
            // Render Warning Error Screen
        }

        AppErrorType.SESSION_EXPIRED_FULLSCREEN -> TODO()
        AppErrorType.GENERIC_ERROR_FULLSCREEN -> {
            GenericErrorScreen(
                title = title,
                message = message,
                errorDrawable = if (errorDrawable != 0) errorDrawable else R.drawable.error,
                positiveButtonText = positiveButtonText.ifEmpty { "Okay" },
                negativeButtonText = negativeButtonText,
                onPositiveButtonClick = onPositiveButtonClick,
                onNegativeButtonClick = onNegativeButtonClick
            )
        }
    }
}

enum class AppErrorType {
    NO_INTERNET,
    NO_INTERNET_FULLSCREEN,
    SESSION_EXPIRED,
    SESSION_EXPIRED_FULLSCREEN,
    GENERIC_ERROR,
    GENERIC_ERROR_FULLSCREEN,
    FULLSCREEN_ERROR,
    WARNING
}

@Composable
fun NoInternetScreen(
    modifier: Modifier = Modifier,
    title: String = "No internet connection",
    message: String = "Please check your network or try again later.",
    showRetry: Boolean = true,
    showSettings: Boolean = false,
    retryText: String = "Retry",
    settingsText: String = "Settings",
    onRetry: () -> Unit = {},
    isFullScreen: Boolean = true
) {
    val context = LocalContext.current
    val updatedModifier = modifier
        .then(
            if (isFullScreen) {
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            } else {
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(10.dp)
            }
        )
    Column(
        modifier = updatedModifier
            .padding(10.dp),
        verticalArrangement = if (isFullScreen) Arrangement.Center else Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.wifi_off),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(88.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showRetry) {
                Button(onClick = onRetry) {
                    Text(text = retryText)
                }
            }
            if (showSettings) {
                OutlinedButton(onClick = { openWirelessSettings(context) }) {
                    Text(text = settingsText)
                }
            }
        }
    }
}


@Composable
fun GenericErrorScreen(
    modifier: Modifier = Modifier,
    title: String = "Error",
    message: String = "Something went wrong. Please try again later.",
    errorDrawable: Int = 0,
    positiveButtonText: String = "okay",
    negativeButtonText: String = "Cancel",
    onPositiveButtonClick: () -> Unit,
    onNegativeButtonClick: () -> Unit,
    isFullScreen: Boolean = true
) {
    val context = LocalContext.current
    val updatedModifier = modifier
        .then(
            if (isFullScreen) {
                Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            } else {
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(10.dp)
            }
        )
    Column(
        modifier = updatedModifier
            .padding(10.dp),
        verticalArrangement = if (isFullScreen) Arrangement.SpaceBetween else Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = errorDrawable),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(88.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (positiveButtonText.isNotEmpty()) {
                Button(onClick = onPositiveButtonClick) {
                    Text(text = positiveButtonText)
                }
            }
            if (negativeButtonText.isNotEmpty()) {
                OutlinedButton(onClick = onNegativeButtonClick) {
                    Text(text = negativeButtonText)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoInternetScreenFullScreenPreview() {
    MaterialTheme {
        NoInternetScreen(
            showRetry = true,
            showSettings = true,
            onRetry = {}
        )
    }
}

fun openWirelessSettings(context: Context) {
    val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(intent)
}


@Preview(showBackground = true)
@Composable
private fun NoInternetScreenPreview() {
    MaterialTheme {
        AppErrorScreen(
            onPositiveButtonClick = {},
            onNegativeButtonClick = {},
            errorType = AppErrorType.NO_INTERNET
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GenericErrorScreenPreview() {
    MaterialTheme {
        AppErrorScreen(
            title = "Data Error",
            message = "There was a problem with data parsing.",
            errorDrawable = R.drawable.error,
            positiveButtonText = "Okay",
            negativeButtonText = "Cancel",
            onPositiveButtonClick = {},
            onNegativeButtonClick = {},
            errorType = AppErrorType.GENERIC_ERROR_FULLSCREEN
        )
    }
}

