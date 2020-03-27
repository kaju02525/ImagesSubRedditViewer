package com.greedygame.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greedygame.R
import com.greedygame.model.Children
import com.greedygame.ui.ImageViewActivity
import com.greedygame.utils.ImageLoader
import kotlinx.android.synthetic.main.item_row.view.*


class GameAdapter(var list: List<Children>) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Children) {
            itemView.apply {
                ImageLoader(context).displayImage(model.thumbnailResponse?.thumbnail ?: "", image_view)
                image_view.setOnClickListener {
                    context.startActivity(
                        Intent(
                            context,
                            ImageViewActivity::class.java
                        ).putExtra("imageUrl", model.thumbnailResponse?.thumbnail)
                    )
                }
            }
        }
    }

}