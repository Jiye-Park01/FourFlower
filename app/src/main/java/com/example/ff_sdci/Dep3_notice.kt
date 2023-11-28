package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import com.example.ff_sdci.homefragment.MypageFragment

class Dep3_notice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep3_notice)
        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, MypageFragment::class.java)
            startActivity(intent)
        }

        // notice_item과 notice를 연결해주는 코드
        val listView =findViewById<ListView>(R.id.listView)
        val data= listOf("공지1", "공지2", "공지3") // 여기에 공지 제목을 나타내는 데이터를 넣음

        val adapter=ArrayAdapter(this, R.layout.notice_item, data)
        listView.adapter=adapter
    }
    }

