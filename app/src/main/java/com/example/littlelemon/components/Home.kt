package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R

@Composable
fun Home(onNavigateToProfile: () -> Unit) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Box {
                LogoHeader()
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ProfileImage(onNavigateToProfile = onNavigateToProfile)
                }
            }
        }
    }
}

@Composable
fun ProfileImage(onNavigateToProfile: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = stringResource(id = R.string.logo_desc),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(20.dp)
            .height(50.dp)
            .clickable {
                onNavigateToProfile()
            }
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home(onNavigateToProfile = { })
}