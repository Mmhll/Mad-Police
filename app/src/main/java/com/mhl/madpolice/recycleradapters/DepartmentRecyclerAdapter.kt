package com.mhl.madpolice.recycleradapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.Department

class DepartmentRecyclerAdapter (val data : Department, val context : Context): RecyclerView.Adapter<DepartmentRecyclerAdapter.MyVH>() {

    private lateinit var myListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }


    class MyVH (itemView : View, listener : onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView.findViewById(R.id.rec_title)
        var subtitle : TextView = itemView.findViewById(R.id.rec_describe)
        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.department_adapter, parent, false)
        return MyVH(root, myListener)

    }

    override fun onBindViewHolder(holder:MyVH, position: Int) {
        holder.title.text = data.data[position].name
        holder.subtitle.text = data.data[position].address
    }

    override fun getItemCount(): Int {
        return data.data.size
    }
}