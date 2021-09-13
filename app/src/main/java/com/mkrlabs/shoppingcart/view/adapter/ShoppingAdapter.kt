package com.mkrlabs.shoppingcart.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mkrlabs.shoppingcart.R
import com.mkrlabs.shoppingcart.service.source.local.entities.ShoppingItem
import com.mkrlabs.shoppingcart.viewmodel.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingAdapter(
    private var itemList: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {

        val item = itemList.get(position)

        holder.itemView.tvName.text = item.name
        holder.itemView.tvAmount.text = "${item.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(item)
        }
        holder.itemView.ivPlus.setOnClickListener {
            item.amount++
            viewModel.insert(item)
        }
        holder.itemView.ivMinus.setOnClickListener {
            if (item.amount > 0) {
                item.amount--
                viewModel.insert(item)
            }
        }


    }

    fun setItemList(itemList: List<ShoppingItem>){
        this.itemList = itemList
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}