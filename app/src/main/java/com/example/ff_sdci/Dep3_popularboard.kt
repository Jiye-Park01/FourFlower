package com.example.ff_sdci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log

class Dep3_popularboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep3_popularboard)

        val board_recycler: RecyclerView = findViewById(R.id.board_recycler)

        // Log를 추가하여 코드 실행 순서를 확인합니다.
        Log.d("TAG", "onCreate: Before post_list creation")

        val post_list = arrayListOf(
            OnePostView("제목1", "내용", R.drawable.h_thumbs, 2,
                R.drawable.j_time, R.drawable.j_bookmark, R.drawable.h_testimg, System.currentTimeMillis()),
            OnePostView("제목2", "내용", R.drawable.h_thumbs, 2,
                R.drawable.j_time, R.drawable.j_bookmark, R.drawable.h_testimg, System.currentTimeMillis())
        )

        // Log를 추가하여 코드 실행 순서를 확인합니다.
        Log.d("TAG", "onCreate: Before boardAdapter creation")

        val boardAdapter = OnePostViewAdapter(post_list)
        board_recycler.adapter = boardAdapter
        board_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Log를 추가하여 코드 실행 순서를 확인합니다.
        Log.d("TAG", "onCreate: After boardAdapter setup")
    }
}