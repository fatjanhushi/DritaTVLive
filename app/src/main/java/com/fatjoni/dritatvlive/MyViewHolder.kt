package com.fatjoni.dritatvlive

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView

    init {
        textView = itemView.findViewById(R.id.tv_name)
    }
}
