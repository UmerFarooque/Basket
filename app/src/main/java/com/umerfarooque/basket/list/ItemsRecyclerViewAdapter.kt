package com.umerfarooque.basket.list

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.umerfarooque.basket.MainActivity
import com.umerfarooque.basket.R
import com.umerfarooque.basket.data.Item
import com.umerfarooque.basket.detail.ItemDetailFragment
import kotlinx.android.synthetic.main.rv_item.view.*

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
        private var nameTv: TextView = itemView.findViewById(R.id.tv_item_name)
        private var itemIv: ImageView = itemView.findViewById(R.id.iv_item_image)

        fun bind(item: Item) {

            val palette = Palette.from(
                BitmapFactory.decodeResource(
                    itemView.context.resources,
                    item.getImageId()
                )
            ).generate()
            val swatch = palette.lightVibrantSwatch
            if (swatch != null) {
                itemView.content_view.setBackgroundColor(swatch.rgb)
            }
            nameTv.text = item.getName()
            itemIv.setImageResource(item.getImageId())
            itemView.setOnClickListener {
                val fragment = ItemDetailFragment()
                val bundle = Bundle()
                bundle.putBoolean("isFruit", item.isFruit())
                bundle.putString("item", Gson().toJson(item))
                fragment.arguments = bundle
                (itemView.context as MainActivity).navigateTo(fragment, true)
            }
        }
    }
}
