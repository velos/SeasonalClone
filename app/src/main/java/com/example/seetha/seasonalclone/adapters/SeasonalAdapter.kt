package com.example.seetha.seasonalclone.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.seetha.seasonalclone.R
import com.example.seetha.seasonalclone.models.ProduceItem
import com.example.seetha.seasonalclone.util.inflate
import kotterknife.bindView

class SeasonalAdapter(private val items: List<ProduceItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            sortedProduce.add("Fruits")
            sortedProduce.addAll(displayItems.filter { displayItem -> displayItem.type == FRUIT_TYPE })
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


    inner class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val headerLabel: TextView by bindView(R.id.tvHeader)
    }

    inner class BrowseItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView by bindView(R.id.tvName)
        val type: TextView by bindView(R.id.tvType)
        val img: ImageView by bindView(R.id.ivProduce)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val v = parent.context.inflate(R.layout.item_produce, parent, false)
                BrowseItemViewHolder(v)
            }
            else -> {
                val v = parent.context.inflate(R.layout.item_header, parent, false)
                HeaderViewHolder(v)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            VIEW_TYPE_ITEM -> {
                val itemHolder = holder as BrowseItemViewHolder
                val item = itemsWithHeaders[position] as ProduceItem
                itemHolder.name.text = item.name
                itemHolder.type.text = item.type

                Glide.with(holder.itemView)
                        .load(item.imgURL)
                        .into(itemHolder.img)

            }
            VIEW_TYPE_HEADER -> {

                val headerViewHolder = holder as HeaderViewHolder
                val sectionTitle = itemsWithHeaders[position] as String
                headerViewHolder.headerLabel.text = sectionTitle
            }

        }
    }

    override fun getItemCount(): Int = itemsWithHeaders.size
}
