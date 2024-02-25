package com.example.littlelemon.components

import android.provider.ContactsContract.Profile
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Profile() {
    Text(text = "Profile Screen")
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}