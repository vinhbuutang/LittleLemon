package com.example.littlelemon.data.repository

import com.example.littlelemon.data.database.MenuItemDao
import com.example.littlelemon.data.database.MenuItemRoom
import kotlinx.coroutines.flow.Flow

class MenuItemRepository(private val menuDao: MenuItemDao) {
    fun getAllMenuItemsStream(): Flow<List<MenuItemRoom>> = menuDao.getAllMenuItems()

    fun getFilteredMenuItemsStream(category: String): Flow<List<MenuItemRoom>> = menuDao.getFilteredMenuItems(category)
}