package com.umerfarooque.basket.detail

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import com.google.gson.Gson
import com.umerfarooque.basket.MainActivity
import com.umerfarooque.basket.R
import com.umerfarooque.basket.data.Fruit
import com.umerfarooque.basket.data.Item
import com.umerfarooque.basket.data.Vegetable
import kotlinx.android.synthetic.main.fragment_item_detail.*
import kotlinx.android.synthetic.main.fragment_item_detail.view.*

class ItemDetailFragment : Fragment() {

    private var itemObj: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            itemObj = if (bundle.getBoolean("isFruit", true)) {
                Gson().fromJson(bundle.getString("item"), Fruit::class.java)
            } else {
                Gson().fromJson(bundle.getString("item"), Vegetable::class.java)
            }
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

        view.toolbar_detail.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        val item = itemObj
        if (item != null) {
            val palette =
                Palette.from(BitmapFactory.decodeResource(resources, item.getImageId())).generate()
            val swatch = palette.lightVibrantSwatch
            if (swatch != null) {
                view.setBackgroundColor(swatch.rgb)
                (requireActivity() as MainActivity).updateStatusBarColor(swatch.rgb)
            }
            iv_item_image.setImageResource(item.getImageId())
            tv_item_name.text = item.getName()
            tv_item_description.text = item.getDescription()
            tv_energy.text = String.format(":    %s Kcal", item.getEnergy())
            tv_protein.text = String.format(":    %s G", item.getProtein())
            tv_sugar.text = String.format(":    %s G", item.getSugar())
            tv_fat.text = String.format(":    %s G", item.getFat())
        }
    }
}
