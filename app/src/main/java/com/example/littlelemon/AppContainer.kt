package com.example.littlelemon

import android.content.Context
import com.example.littlelemon.database.AppDatabase
import com.example.littlelemon.repository.MenuItemRepository

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val menuItemsRepository: MenuItemRepository
}

/**
 * [AppContainer] implementation that provides instance of [MenuItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [MenuItemsRepository]
     */
    override val menuItemsRepository: MenuItemRepository by lazy {
        MenuItemRepository(AppDatabase.getDatabase(context).menuItemDao())
    }
}