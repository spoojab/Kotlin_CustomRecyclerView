package com.e.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.Model.News
import com.e.kotlin_recyclerview.R

class MyAdapter(var listView:ArrayList<News>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener:onItemClickListener


    interface onItemClickListener{
        fun onItemClick(position:Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.img.setImageResource(listView[position].image)
        holder.title.text=listView[position].title
    }

    override fun getItemCount(): Int {
        return listView.size
    }

    class MyViewHolder(itemView:View,listener: onItemClickListener): RecyclerView.ViewHolder(itemView){
      var img:ImageView=itemView.findViewById(R.id.newsImage)
        var title:TextView=itemView.findViewById(R.id.news_title)

        init{

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }


    }


}