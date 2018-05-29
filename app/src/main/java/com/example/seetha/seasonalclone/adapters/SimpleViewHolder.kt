package com.example.seetha.seasonalclone.adapters

import android.support.v7.widget.RecyclerView
import android.view.View

@Suppress("UNCHECKED_CAST")
class SimpleViewHolder<out T : View>(itemView: T) : RecyclerView.ViewHolder(itemView) {
    val view: T
        get() = itemView as T
}
