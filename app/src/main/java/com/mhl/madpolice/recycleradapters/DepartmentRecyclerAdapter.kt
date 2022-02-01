package com.mhl.madpolice.recycleradapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhl.madpolice.R
import com.mhl.madpolice.apadters.departmentData
import com.mhl.madpolice.databinding.DepartmentAdapterBinding

class DepartmentRecyclerAdapter (val data : ArrayList<departmentData>, val context : Context): RecyclerView.Adapter<DepartmentRecyclerAdapter.MyVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root = LayoutInflater.from(context).inflate(R.layout.department_adapter, parent, false)
        return MyVH(root)
    }

    class MyVH (itemView : View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView = itemView.findViewById(R.id.rec_title)
        var subtitle : TextView = itemView.findViewById(R.id.rec_describe)
    }

    override fun onBindViewHolder(holder:MyVH, position: Int) {
        holder.title.text = data[position].name
        holder.subtitle.text = data[position].description
    }

    override fun getItemCount(): Int {
        return data.size
    }
}