package com.example.littlelemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.littlelemon.R
import com.example.littlelemon.ResourceProvider
import com.example.littlelemon.data.database.MenuItemRoom
import com.example.littlelemon.data.repository.MenuItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeViewModel(
    private val repository: MenuItemRepository,
    private val resourceProvider: ResourceProvider
) : ViewModel() {
    fun getMenu(): Flow<List<MenuItemRoom>> {
        return repository.getAllMenuItemsStream()
    }

    fun getFilteredMenu(category: String, searchPhrase: String): Flow<List<MenuItemRoom>> {
        val menu = if (category == resourceProvider.getString(R.string.all_categories)) {
            getMenu()
        } else {
            repository.getFilteredMenuItemsStream(category)
        }

        return if (searchPhrase == "") {
            menu
        } else {
            menu.map { list ->
                list.filter {
                    it.title.contains(searchPhrase, ignoreCase = true)
                }
            }
        }
    }
}