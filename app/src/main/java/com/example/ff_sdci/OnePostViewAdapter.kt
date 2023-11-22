package com.example.ff_sdci

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date


class OnePostViewAdapter (val itemList: ArrayList<OnePostView>) : RecyclerView.Adapter<OnePostViewAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnePostViewAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_one_board, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.title_f.text = itemList[position].title_f
        holder.content_f.text = itemList[position].content_f
        holder.like_image.setImageResource(itemList.get(position).like_image)
        holder.time_image.setImageResource(itemList.get(position).time_image)
        holder.like_count.text = itemList[position].like_count.toString()
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formattedTime = simpleDateFormat.format(Date(itemList[position].write_time))
        holder.write_time.text = formattedTime
        holder.bookmark.setImageResource(itemList.get(position).bookmark)
        holder.post_image.setImageResource(itemList.get(position).post_image)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title_f = itemView.findViewById<TextView>(R.id.title_f)
        val content_f = itemView.findViewById<TextView>(R.id.content_f)
        val like_image = itemView.findViewById<ImageView>(R.id.like_f)
        val like_count = itemView.findViewById<TextView>(R.id.like_count)
        val time_image = itemView.findViewById<ImageView>(R.id.time_f)
        val write_time = itemView.findViewById<TextView>(R.id.timeline)
        val bookmark = itemView.findViewById<ImageView>(R.id.bookmark)
        val post_image = itemView.findViewById<ImageView>(R.id.post_image)

    }


}
