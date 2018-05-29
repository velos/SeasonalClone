package com.example.seetha.seasonalclone.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.seetha.seasonalclone.models.ProduceItem
import views.BrowseItemView
import views.HeaderItemView

class SeasonalAdapter(private var items: List<ProduceItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val FRUIT_TYPE = "Fruit"
    val VEGETABLE_TYPE = "Vegetable"
    val HERB_TYPE = "Herb"
    val LEGUME_TYPE = "Legume"
    val NUT_TYPE = "Nut"

    private val itemsWithHeaders = sortItemsByHeader(items)

    init {
        notifyDataSetChanged()
    }

    private fun sortItemsByHeader(items: List<ProduceItem>): List<Any> {

        val displayItems = items.filter { item -> item.display }
        val sortedProduce = mutableListOf<Any>()
        if (displayItems.isNotEmpty()) {
            sortedProduce.add(0, "Fruits")
            sortedProduce.addAll(displayItems.filter { displayItem -> displayItem.type == FRUIT_TYPE })
        }
        if (items.isNotEmpty()) {
            sortedProduce.add("Veggies")
            sortedProduce.addAll(displayItems.filter { displayItem ->
                listOf(VEGETABLE_TYPE, HERB_TYPE, LEGUME_TYPE, NUT_TYPE).contains(displayItem.type)
            })
        }

        return sortedProduce

    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }


    override fun getItemViewType(position: Int): Int {
        if (itemsWithHeaders[position] is ProduceItem) {
            return VIEW_TYPE_ITEM
        }

        return VIEW_TYPE_HEADER
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val view = BrowseItemView.inflate(parent)
                SimpleViewHolder(view)
            }
            else -> {
                val headerView = HeaderItemView.inflate(parent)
                SimpleViewHolder(headerView)
            }
        }


    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_ITEM -> {
                val itemHolder = holder as SimpleViewHolder<BrowseItemView>
                itemHolder.view.produce = itemsWithHeaders[position] as ProduceItem
            }
            VIEW_TYPE_HEADER -> {
                val headerHolder = holder as SimpleViewHolder<HeaderItemView>
                headerHolder.view.header = itemsWithHeaders[position].toString()
            }

        }
    }

    override fun getItemCount(): Int = itemsWithHeaders.size


}
