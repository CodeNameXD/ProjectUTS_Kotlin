package com.example.projectuts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Currency

class PixelAdapter(private val pixelList : ArrayList<Pixel>, val listener: (Pixel) -> Unit)
    : RecyclerView.Adapter<PixelAdapter.PixelViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixelViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pixel, parent, false)
        return PixelViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PixelViewHolder, position: Int) {
        holder.bindView(pixelList[position],listener)

        val currentItem = pixelList[position]
        holder.imagePixel.setImageResource(currentItem.imagePixel)
        holder.namePixel.text = currentItem.namePixel
        holder.descPixel.text = currentItem.descPixel
        itemCount
    }

    override fun getItemCount(): Int {
        return pixelList.size
    }

    class PixelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imagePixel : ImageView = itemView.findViewById(R.id.tv_img)
        val namePixel : TextView = itemView.findViewById(R.id.tv_name)
        val descPixel : TextView = itemView.findViewById(R.id.tv_desc)

        fun bindView(Pixel: Pixel, listener: (Pixel) -> Unit) {
            imagePixel.setImageResource(Pixel.imagePixel)
            namePixel.text = Pixel.namePixel
            descPixel.text = Pixel.descPixel
            itemView.setOnClickListener{
                listener(Pixel)
            }

        }
    }
}