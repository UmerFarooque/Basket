package com.umerfarooque.basket.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.umerfarooque.basket.MainActivity
import com.umerfarooque.basket.R
import com.umerfarooque.basket.data.Item
import com.umerfarooque.basket.detail.ItemDetailFragment

class ItemsRecyclerViewAdapter(var items: List<Item>?) :
    RecyclerView.Adapter<ItemsRecyclerViewAdapter.ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ItemsViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        if (items != null) {
            holder.bind(items!![position])
        }
    }

    inner class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTv: TextView = itemView.findViewById(R.id.tv_item_name)
        var itemIv: ImageView = itemView.findViewById(R.id.iv_item_image)

        fun bind(item: Item) {
            itemView.setOnClickListener {
                val fragment = ItemDetailFragment()
                val bundle = Bundle()
                bundle.putString("item", Gson().toJson(item))
                fragment.arguments = bundle
                (itemView.context as MainActivity).navigateTo(ItemDetailFragment(), true)
            }
        }
    }
}
