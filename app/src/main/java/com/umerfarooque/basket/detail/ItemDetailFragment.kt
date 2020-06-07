package com.umerfarooque.basket.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.umerfarooque.basket.R
import com.umerfarooque.basket.data.Item
import kotlinx.android.synthetic.main.fragment_item_detail.*


class ItemDetailFragment : Fragment() {

    private var itemObj: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            itemObj = Gson().fromJson(bundle.getString("item"), Item::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = itemObj
        if (item != null) {
            iv_item_image.setImageResource(item.getImageId())
            tv_item_name.text = item.getName()
            tv_item_description.text = item.getDescription()
            tv_energy.text = item.getEnergy()
            tv_protein.text = item.getProtein()
            tv_sugar.text = item.getSugar()
            tv_fat.text = item.getFat()
        }
    }
}
