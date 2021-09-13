package com.mkrlabs.shoppingcart.service.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ShoppingItem)

    @Delete
    suspend fun deleteItem(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
     fun getAllShoppingList():LiveData<List<ShoppingItem>>
}