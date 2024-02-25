package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.KarlaTypography
import com.example.littlelemon.ui.theme.highlight
import com.example.littlelemon.ui.theme.highlightVariant
import com.example.littlelemon.ui.theme.primary
import com.example.littlelemon.ui.theme.primaryVariant


@Composable
fun Onboarding() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            var firstName by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }

            OnboardingHeader()
            OnboardingForm(
                firstName = firstName,
                onFirstNameChange = { firstName = it },
                lastName = lastName,
                onLastNameChange = { lastName = it },
                email = email,
                onEmailChange = { email = it }
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
                onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(id = R.string.register),
                        style = KarlaTypography.formButton,
                        modifier = Modifier.padding(5.dp)
                    )
            }
        }
    }
}

@Composable
fun OnboardingHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo_desc),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(50.dp)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = primary,
                contentColor = highlight
            ),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_display),
                    style = KarlaTypography.displayMedium
                )
            }
        }
    }
}

@Composable
fun OnboardingForm(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(
            text = stringResource(id = R.string.form_title),
            style = KarlaTypography.sectionTitle,
            modifier = Modifier.padding(top = 20.dp)
        )

        LittleLemonFormField(
            label = stringResource(id = R.string.first_name),
            formValue = firstName,
            onFormValueChange = onFirstNameChange
        )

        LittleLemonFormField(
            label = stringResource(id = R.string.last_name),
            formValue = lastName,
            onFormValueChange = onLastNameChange
        )

        LittleLemonFormField(
            label = stringResource(id = R.string.email),
            formValue = email,
            onFormValueChange = onEmailChange
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LittleLemonFormField(
    label: String,
    formValue: String,
    onFormValueChange: (String) -> Unit
) {
    OutlinedTextField(
        singleLine = true,
        label = {
            Text(
                text = label,
                style = KarlaTypography.leadText
            )
        },
        value = formValue,
        onValueChange = onFormValueChange,
        textStyle = KarlaTypography.formField,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}