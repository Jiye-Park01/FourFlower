package com.example.ff_sdci.Dep2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep2_boards
import com.example.ff_sdci.R
import com.example.ff_sdci.R.id.dep2_chatRecycler

class Dep2_Chatting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_chatting)

        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }



        val recyclerView=findViewById<RecyclerView>(dep2_chatRecycler)
        recyclerView.layoutManager=LinearLayoutManager(this)

      //  val chatList= listOf(
           // ChatRoom("채팅방 1","마지막 메시지 1", R.drawable.)
     //   )
    }
}