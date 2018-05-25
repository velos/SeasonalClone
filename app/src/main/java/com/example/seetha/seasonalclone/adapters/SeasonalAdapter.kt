package com.example.seetha.seasonalclone.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.seetha.seasonalclone.models.ProduceItem
import com.example.seetha.seasonalclone.util.inflate
import com.example.seetha.seasonalclone.R

class SeasonalAdapter(private var items: List<ProduceItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = parent.context.inflate(R.layout.item_produce, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val name = items[position].name
        val type = items[position].type

        val viewHolder = holder as ViewHolder
        viewHolder.tvName.text = name
        viewHolder.tvType.text = type

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvType: TextView = itemView.findViewById(R.id.tvType)

    }
}
