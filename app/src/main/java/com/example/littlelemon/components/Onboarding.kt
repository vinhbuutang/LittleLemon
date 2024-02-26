package com.example.littlelemon.components

import android.content.Context
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.KarlaTypography
import com.example.littlelemon.ui.theme.highlight
import com.example.littlelemon.ui.theme.highlightVariant
import com.example.littlelemon.ui.theme.primary
import com.example.littlelemon.ui.theme.primaryVariant


@Composable
fun Onboarding(onNavigateToHome: () -> Unit) {
    val context = LocalContext.current

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
                onClick = {
                    formRegister(
                        firstName = firstName,
                        lastName = lastName,
                        email = email,
                        context = context,
                        onNavigateToHome = onNavigateToHome
                    )
                }
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    style = KarlaTypography.formButton,
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

fun validateFormFields(firstName: String, lastName: String, email: String): Boolean {
    return !(firstName.isBlank() || lastName.isBlank() || !validateEmail(email))
}

fun validateEmail(email: String): Boolean {
    return EMAIL_ADDRESS.matcher(email).matches()
}

fun formRegister(
    firstName: String,
    lastName: String,
    email: String,
    context: Context,
    onNavigateToHome: () -> Unit
) {
    val registerSuccess = validateFormFields(
        firstName = firstName,
        lastName = lastName,
        email = email,
    )
    val sharedPreferences = context.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    if (registerSuccess) {
        Toast.makeText(context, R.string.register_success, LENGTH_SHORT).show()
        sharedPreferences.edit(commit = true) {
            putString("firstName", firstName)
            putString("lastName", lastName)
            putString("email", email)
        }
        onNavigateToHome()
    } else {
        Toast.makeText(
            context,
            R.string.register_fail,
            LENGTH_SHORT
        ).show()
    }
}


@Composable
fun LogoHeader() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.logo_desc),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(50.dp)
    )
}

@Composable
fun OnboardingHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LogoHeader()
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
    onFirstNameChange: (String) -> Unit = { },
    lastName: String,
    onLastNameChange: (String) -> Unit = { },
    email: String,
    onEmailChange: (String) -> Unit = { },
    readOnly: Boolean = false,
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
            onFormValueChange = onFirstNameChange,
            readOnly = readOnly,
        )

        LittleLemonFormField(
            label = stringResource(id = R.string.last_name),
            formValue = lastName,
            onFormValueChange = onLastNameChange,
            readOnly = readOnly,
        )

        LittleLemonFormField(
            label = stringResource(id = R.string.email),
            formValue = email,
            onFormValueChange = onEmailChange,
            readOnly = readOnly,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LittleLemonFormField(
    label: String,
    formValue: String,
    onFormValueChange: (String) -> Unit,
    readOnly: Boolean = false
) {
    OutlinedTextField(
        singleLine = true,
        readOnly = readOnly,
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
    Onboarding(onNavigateToHome = { })
}