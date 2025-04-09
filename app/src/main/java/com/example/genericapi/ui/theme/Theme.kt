package com.example.genericapi.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun GenericApiAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content
    )
}
