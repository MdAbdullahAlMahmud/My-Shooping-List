package com.mkrlabs.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem
import com.mkrlabs.shoppingcart.service.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repo:ShoppingRepository)  : ViewModel() {

    fun insert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repo.insertShopItem(item)
    }
    fun delete (item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch { repo.deleteShopItem(item) }

    fun getAllShoppingList() = repo.getAllShoppingList()
}