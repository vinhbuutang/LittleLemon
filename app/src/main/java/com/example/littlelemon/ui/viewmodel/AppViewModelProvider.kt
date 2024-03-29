package com.example.littlelemon.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.littlelemon.LittleLemonApplication

/**
 * Provides Factory to create instance of ViewModel for the entire Inventory app
 */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for HomeViewModel
        initializer {
            val container = littleLemonApplication().container
            HomeViewModel(container.menuItemsRepository, container.resourceProvider)
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [LittleLemonApplication].
 */
fun CreationExtras.littleLemonApplication(): LittleLemonApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as LittleLemonApplication)
