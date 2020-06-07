package com.umerfarooque.basket.list

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.umerfarooque.basket.R
import com.umerfarooque.basket.data.Item
import com.umerfarooque.basket.data.ItemCollection
import kotlinx.android.synthetic.main.fragment_item_list.*
import kotlinx.android.synthetic.main.fragment_item_list.view.*

class ItemListFragment : Fragment() {

    private var backdropShown = false
    private val animatorSet = AnimatorSet()
    private var height: Int? = null
    private var openIcon: Drawable? = null
    private var closeIcon: Drawable? = null
    private var interpolator: Interpolator? = null
    private var showFruits = true

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
        openIcon = ContextCompat.getDrawable(context, R.drawable.ic_baseline_filter_list_24)
        closeIcon = ContextCompat.getDrawable(context, R.drawable.ic_baseline_close_24)
        interpolator = AccelerateDecelerateInterpolator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.rv_item_list.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        view.rv_item_list.layoutManager = gridLayoutManager
        setupRecyclerView(getItems())
        val adapter = ItemsRecyclerViewAdapter(ItemCollection.getFruitsList())
        view.rv_item_list.adapter = adapter
    }

    private fun setupRecyclerView(items: List<Item>) {
        val adapter: ItemsRecyclerViewAdapter
        if (rv_item_list.adapter == null) {
            adapter = ItemsRecyclerViewAdapter(getItems())
            rv_item_list.adapter = adapter
        } else {
            adapter = rv_item_list.adapter as ItemsRecyclerViewAdapter
        }
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.filter) {
            backdropShown = !backdropShown
            animatorSet.removeAllListeners()
            animatorSet.end()
            animatorSet.cancel()
            updateIcon(item)
            val translateY =
                height?.minus(requireContext().resources.getDimensionPixelSize(R.dimen.list_reveal_height))

            val animator = ObjectAnimator.ofFloat(
                requireView().nsv_list, "translationY",
                (if (backdropShown) translateY else 0)!!.toFloat()
            )
            animator.duration = 500
            if (interpolator != null) {
                animator.interpolator = interpolator
            }
            animatorSet.play(animator)
            animator.start()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateIcon(item: MenuItem) {
        if (openIcon != null && closeIcon != null) {
            if (backdropShown) {
                item.icon = closeIcon
            } else {
                item.icon = openIcon
            }
        }
    }

    private fun getItems(): List<Item> {
        val list: List<Item> = if (showFruits) {
            ItemCollection.getFruitsList()
        } else {
            ItemCollection.getVegetablesList()
        }
        showFruits = !showFruits
        return list
    }
}
