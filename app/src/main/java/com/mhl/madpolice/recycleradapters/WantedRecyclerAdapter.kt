package com.mhl.madpolice.recycleradapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.Wanted
import com.squareup.picasso.Picasso

class WantedRecyclerAdapter (val data : Wanted, val context : Context) : RecyclerView.Adapter<WantedRecyclerAdapter.VH>() {

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    class VH (itemView : View, listener : onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.wantedImage)
        var initials : TextView = itemView.findViewById(R.id.wantedName)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val root = LayoutInflater.from(context).inflate(R.layout.wanted_adapter, parent, false)
        return VH(root, myListener)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        Picasso.get().load(data.data[position].photo).into(holder.image)
        val string = data.data[position].first_name + data.data[position].last_name
        Log.d("String", data.data[position].last_name)
        holder.initials.text = string
    }

    override fun getItemCount(): Int {
        return data.data.size
    }
}