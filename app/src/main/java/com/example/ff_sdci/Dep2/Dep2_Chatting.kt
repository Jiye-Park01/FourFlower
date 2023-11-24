package com.example.ff_sdci.Dep2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ff_sdci.R
import com.example.ff_sdci.R.id.dep2_chatRecycler

class Dep2_Chatting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_chatting)


        val recyclerView=findViewById<RecyclerView>(dep2_chatRecycler)
        recyclerView.layoutManager=LinearLayoutManager(this)

      //  val chatList= listOf(
           // ChatRoom("채팅방 1","마지막 메시지 1", R.drawable.)
     //   )
    }
}