package com.mkrlabs.shoppingcart.service.repositories

import com.mkrlabs.shoppingcart.service.source.local.ShoppingDatabase
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem

class ShoppingRepository(private val db: ShoppingDatabase) {

    suspend fun insertShopItem(item: ShoppingItem) = db.shopDao().insertItem(item)
    suspend fun deleteShopItem(item: ShoppingItem) = db.shopDao().deleteItem(item)

    fun getAllShoppingList() = db.shopDao().getAllShoppingList()
}