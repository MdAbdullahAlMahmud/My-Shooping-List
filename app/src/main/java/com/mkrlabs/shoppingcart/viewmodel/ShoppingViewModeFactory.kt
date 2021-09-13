package com.mkrlabs.shoppingcart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mkrlabs.shoppingcart.service.repositories.ShoppingRepository

class ShoppingViewModeFactory(private val repository: ShoppingRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}