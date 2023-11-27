package com.example.ff_sdci

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dep2_boards : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_boards)

        val boardRecycler1: RecyclerView = findViewById(R.id.board_recycler1)
        val boardRecycler2: RecyclerView = findViewById(R.id.board_recycler2)
        val boardRecycler3: RecyclerView = findViewById(R.id.board_recycler3)
        val boardRecycler4: RecyclerView = findViewById(R.id.board_recycler4)
        val boardRecycler5: RecyclerView = findViewById(R.id.board_recycler5)
        val boardRecycler6: RecyclerView = findViewById(R.id.board_recycler6)

        val titleList1 = arrayListOf(
            OneTitleView("제목 1"),
            OneTitleView("제목 2"),
            OneTitleView("제목 3"),
            OneTitleView("제목 4")
        )

        val titleList2 = arrayListOf(
            OneTitleView("제목 5"),
            OneTitleView("제목 6"),
            OneTitleView("제목 7"),
            OneTitleView("제목 8")
        )

        val titleList3 = arrayListOf(
            OneTitleView("제목 9"),
            OneTitleView("제목 10"),
            OneTitleView("제목 11"),
            OneTitleView("제목 12")
        )

        val titleList4 = arrayListOf(
            OneTitleView("제목 13"),
            OneTitleView("제목 14"),
            OneTitleView("제목 15"),
            OneTitleView("제목 16")
        )

        val titleList5 = arrayListOf(
            OneTitleView("제목 17"),
            OneTitleView("제목 18"),
            OneTitleView("제목 19"),
            OneTitleView("제목 20")
        )

        val titleList6 = arrayListOf(
            OneTitleView("제목 21"),
            OneTitleView("제목 22"),
            OneTitleView("제목 23"),
            OneTitleView("제목 24")
        )

        val boardAdapter1 = OneTitleViewAdapter(titleList1)
        boardRecycler1.adapter = boardAdapter1
        boardRecycler1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val boardAdapter2 = OneTitleViewAdapter(titleList2)
        boardRecycler2.adapter = boardAdapter2
        boardRecycler2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val boardAdapter3 = OneTitleViewAdapter(titleList3)
        boardRecycler3.adapter = boardAdapter3
        boardRecycler3.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val boardAdapter4 = OneTitleViewAdapter(titleList4)
        boardRecycler4.adapter = boardAdapter4
        boardRecycler4.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val boardAdapter5 = OneTitleViewAdapter(titleList5)
        boardRecycler5.adapter = boardAdapter5
        boardRecycler5.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val boardAdapter6 = OneTitleViewAdapter(titleList6)
        boardRecycler6.adapter = boardAdapter6
        boardRecycler6.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}