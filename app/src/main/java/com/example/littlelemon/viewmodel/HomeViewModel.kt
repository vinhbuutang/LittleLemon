package com.example.littlelemon.viewmodel

import androidx.lifecycle.ViewModel
import com.example.littlelemon.database.MenuItemRoom
import com.example.littlelemon.repository.MenuItemRepository
import kotlinx.coroutines.flow.Flow

class HomeViewModel(private val repository: MenuItemRepository) : ViewModel() {
    fun getMenu(): Flow<List<MenuItemRoom>> {
        return repository.getAllMenuItemsStream()
    }
}