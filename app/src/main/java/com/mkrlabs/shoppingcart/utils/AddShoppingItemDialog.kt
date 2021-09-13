package com.mkrlabs.shoppingcart.utils

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.mkrlabs.shoppingcart.R
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context: Context, val  listener: addDialogListener) : AppCompatDialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Field required",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (amount.toInt()<0){
                Toast.makeText(context,"amount could not be 0",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val  shoppingItem = ShoppingItem(name,amount.toInt())
            listener.itemAdded(shoppingItem)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }

    interface addDialogListener{
        fun itemAdded(shoppingItem: ShoppingItem)
    }
}