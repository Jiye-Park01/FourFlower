package com.example.ff_sdci

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class OneAlarmAdapter (val itemList: ArrayList<OneAlarmView>) : RecyclerView.Adapter<OneAlarmAdapter.CustomViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    // (1) 리스트 내 항목 클릭 시 onClick() 호출
    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categories = itemView.findViewById<TextView>(R.id.category1)
        val alarm_comments = itemView.findViewById<TextView>(R.id.aram_comment1)
        val alarm_cotent = itemView.findViewById<TextView>(R.id.title_1)

        fun bind(item: OneAlarmView) {
            categories.text = item.categories
            alarm_comments.text = item.alarm_comments
            alarm_cotent.text = item.alarm_content
        }
    }
}








