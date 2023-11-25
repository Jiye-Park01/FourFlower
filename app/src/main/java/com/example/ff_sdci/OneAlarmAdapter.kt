package com.example.ff_sdci

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class OneAlarmAdapter (val itemList: ArrayList<OneAlarmView>) : RecyclerView.Adapter<OneAlarmAdapter.CustomViewHolder>(){



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OneAlarmAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.categories.text = itemList[position].categories
        holder.alarm_comments.text = itemList[position].alarm_comments
        holder.alarm_cotent.text = itemList[position].alarm_content
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }



    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categories = itemView.findViewById<TextView>(R.id.category1)
        val alarm_comments = itemView.findViewById<TextView>(R.id.aram_comment1)
        val alarm_cotent = itemView.findViewById<TextView>(R.id.title_1)
        }

    }



