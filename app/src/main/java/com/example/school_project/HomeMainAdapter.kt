package com.example.school_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.school_project.homeMainModel.HomeMainData

class HomeMainAdapter(private val context:Context,private val dataList:List<HomeMainData>):
    RecyclerView.Adapter<HomeMainAdapter.ViewHolder>() {
    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
val homeMainIV:ImageView=view.findViewById(R.id.homemainIV)
        val homeMainTitleTV:TextView=view.findViewById(R.id.homemainTitleTV)
        val homeMainSubTitleTV:TextView=view.findViewById(R.id.homemainSubTitleTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
 val  view:View=LayoutInflater.from(context).inflate(R.layout.homemain_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.homeMainTitleTV.text=dataList.get(position).title
        holder.homeMainSubTitleTV.text=dataList.get(position).sub_title
        Glide.with(context).load(dataList.get(position).imageRes).into(holder.homeMainIV)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}