package com.mkrlabs.shoppingcart.service.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)

abstract class ShoppingDatabase : RoomDatabase() {

     abstract fun shopDao(): ShoppingDao;

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance =it }

        }
        private fun  createDatabase(context : Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java,"shop_db").build()
    }


}