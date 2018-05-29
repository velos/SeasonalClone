package com.example.seetha.seasonalclone.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.seetha.seasonalclone.models.ProduceItem
import views.BrowseItemView

class SeasonalAdapter(private var items: List<ProduceItem>) : RecyclerView.Adapter<SeasonalAdapter.ViewHolder>() {

    init {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = BrowseItemView.inflate(parent)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.browseItemView.produce = items[position]

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal val browseItemView: BrowseItemView = v as BrowseItemView
    }

}
