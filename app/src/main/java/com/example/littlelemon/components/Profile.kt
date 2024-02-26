package com.example.littlelemon.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.KarlaTypography
import com.example.littlelemon.ui.theme.highlightVariant
import com.example.littlelemon.ui.theme.primaryVariant

@Composable
fun Profile(onNavigateToOnboarding: () -> Unit) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)

    val firstName = sharedPreferences.getString("firstName", "")!!
    val lastName = sharedPreferences.getString("lastName", "")!!
    val email = sharedPreferences.getString("email", "")!!

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            LogoHeader()
            OnboardingForm(
                firstName = firstName,
                lastName = lastName,
                email = email,
                readOnly = true
            )

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryVariant,
                    contentColor = highlightVariant
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                onClick = {
                    onNavigateToOnboarding()
                    sharedPreferences.edit().clear().apply()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.logout),
                    style = KarlaTypography.formButton,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile(onNavigateToOnboarding = { })
}