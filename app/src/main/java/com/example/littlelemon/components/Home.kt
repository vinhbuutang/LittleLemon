package com.example.littlelemon.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home() {
    Text(text = "Home Screen")
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}