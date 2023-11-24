package com.example.ff_sdci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class Dep3_notice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep3_notice)

        // notice_item과 notice를 연결해주는 코드
        val listView =findViewById<ListView>(R.id.listView)
        val data= listOf("공지1", "공지2", "공지3") // 여기에 공지 제목을 나타내는 데이터를 넣음

        val adapter=ArrayAdapter(this, R.layout.notice_item, data)
        listView.adapter=adapter
    }
    }

