package com.example.littlelemon.repository

import com.example.littlelemon.database.MenuItemDao
import com.example.littlelemon.database.MenuItemRoom
import kotlinx.coroutines.flow.Flow

class MenuItemRepository(private val menuDao: MenuItemDao) {
    fun getAllMenuItemsStream(): Flow<List<MenuItemRoom>> = menuDao.getAllMenuItems()

    fun getFilteredMenuItemsStream(category: String): Flow<List<MenuItemRoom>> = menuDao.getFilteredMenuItems(category)
}