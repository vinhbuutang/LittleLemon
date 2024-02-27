package com.example.littlelemon.ui.components.home

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
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.littlelemon.R
import com.example.littlelemon.ui.components.onboard.LogoHeader
import com.example.littlelemon.ui.viewmodel.AppViewModelProvider
import com.example.littlelemon.ui.viewmodel.HomeViewModel
import java.util.Locale

@Composable
fun HomeScreen(onNavigateToProfile: () -> Unit) {
    var searchPhrase by remember { mutableStateOf("") }

    val homeViewModel: HomeViewModel = viewModel(factory = AppViewModelProvider.Factory)
    var selectedCategory by remember {
        mutableStateOf("all")
    }
    val filteredMenu by homeViewModel.getFilteredMenu(selectedCategory, searchPhrase)
        .collectAsState(initial = emptyList())

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
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
                Intro(searchPhrase = searchPhrase) {
                    searchPhrase = it
                }
            }
            Column {
                MenuCategory {
                    selectedCategory = it.lowercase(Locale.ROOT)
                }
                MenuItems(menu = filteredMenu)
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
fun HomeScreenPreview() {
    HomeScreen(onNavigateToProfile = { })
}