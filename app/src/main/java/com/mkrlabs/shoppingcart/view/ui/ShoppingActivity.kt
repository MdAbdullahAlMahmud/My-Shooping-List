package com.mkrlabs.shoppingcart.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mkrlabs.shoppingcart.R
import com.mkrlabs.shoppingcart.service.source.local.ShoppingDatabase
import com.mkrlabs.shoppingcart.service.repositories.ShoppingRepository
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem
import com.mkrlabs.shoppingcart.utils.AddShoppingItemDialog
import com.mkrlabs.shoppingcart.view.adapter.ShoppingAdapter
import com.mkrlabs.shoppingcart.viewmodel.ShoppingViewModeFactory
import com.mkrlabs.shoppingcart.viewmodel.ShoppingViewModel
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), AddShoppingItemDialog.addDialogListener,KodeinAware {
    lateinit var shoppingViewModel: ShoppingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        shoppingViewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)


        val adapter = ShoppingAdapter(listOf(), shoppingViewModel)
        rvShopping.layoutManager = LinearLayoutManager(this)

        rvShopping.adapter = adapter
        shoppingViewModel.getAllShoppingList().observe(this, Observer {
            adapter.setItemList(it)
            adapter.notifyDataSetChanged()
        })

        floatingActionButton.setOnClickListener {

            AddShoppingItemDialog(this, this).show()

        }
    }

    override fun itemAdded(shoppingItem: ShoppingItem) {
        shoppingViewModel.insert(shoppingItem)
    }

    override val kodein by kodein()
    private val factory : ShoppingViewModeFactory by instance()

}