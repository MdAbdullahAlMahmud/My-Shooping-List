package com.mkrlabs.shoppingcart.service.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    var name : String,
    var amount :Int,
){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}
