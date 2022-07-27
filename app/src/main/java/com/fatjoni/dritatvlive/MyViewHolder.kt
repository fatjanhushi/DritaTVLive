package com.fatjoni.dritatvlive

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fatjoni.dritatvlive.databinding.ChannelItemBinding
import com.google.android.material.button.MaterialButton


class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView: TextView
    val imageView: ImageView
    val streamBtn: MaterialButton

    init {
        textView = itemView.findViewById(R.id.tv_name)
        imageView = itemView.findViewById(R.id.imageView)
        streamBtn = itemView.findViewById(R.id.btn_stream)
    }
}
