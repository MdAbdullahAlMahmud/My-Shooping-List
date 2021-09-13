package com.mkrlabs.shoppingcart

import android.app.Application
import com.mkrlabs.shoppingcart.service.repositories.ShoppingRepository
import com.mkrlabs.shoppingcart.service.source.local.ShoppingDatabase
import com.mkrlabs.shoppingcart.viewmodel.ShoppingViewModeFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingApplication() : Application(), KodeinAware {

    override val kodein: Kodein
        get() = Kodein.lazy {
            import(androidXModule(this@ShoppingApplication))

            bind() from  singleton{ShoppingDatabase(instance())}
            bind() from  singleton { ShoppingRepository(instance())  }
            bind() from  provider { ShoppingViewModeFactory(instance())}
        }
}