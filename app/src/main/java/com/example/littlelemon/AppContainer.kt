package com.example.littlelemon

import android.content.Context
import com.example.littlelemon.data.database.AppDatabase
import com.example.littlelemon.data.repository.MenuItemRepository

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val menuItemsRepository: MenuItemRepository
    val resourceProvider: ResourceProvider
}

/**
 * [AppContainer] implementation that provides instance of [MenuItemsRepository] and [ResourceProvider]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [MenuItemsRepository]
     */
    override val menuItemsRepository: MenuItemRepository by lazy {
        MenuItemRepository(AppDatabase.getDatabase(context).menuItemDao())
    }

    override val resourceProvider: ResourceProvider by lazy {
        ResourceProvider(context)
    }

}