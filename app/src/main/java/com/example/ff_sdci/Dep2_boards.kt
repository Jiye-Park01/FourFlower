package com.example.ff_sdci

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ff_sdci.Dep2.Dep2_Chatting
import com.example.ff_sdci.Dep2.Dep2_Mypage
import com.example.ff_sdci.Dep2.Dep2_menu
import com.example.ff_sdci.board.Dep3_Noticeboard
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dep2_boards : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_boards)



        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }

        val noticeBoard = findViewById<TextView>(R.id.textMyInfo1)
        noticeBoard.setOnClickListener {
            Toast.makeText(this, "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_Noticeboard::class.java)
            startActivity(intent)
        }

        val PopularBoard = findViewById<TextView>(R.id.textMyInfo2)
        PopularBoard.setOnClickListener {
            Toast.makeText(this, "인기 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_popularboard::class.java)
            startActivity(intent)
        }

        val marketBoard = findViewById<TextView>(R.id.textMyInfo3)
        marketBoard.setOnClickListener {
            Toast.makeText(this, "장터 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_marketboard::class.java)
            startActivity(intent)
        }

        val promotionBoard = findViewById<TextView>(R.id.textMyInfo4)
        promotionBoard.setOnClickListener {
            Toast.makeText(this, "홍보 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_promotionboard::class.java)
            startActivity(intent)
        }
        val anonymousboardBoard = findViewById<TextView>(R.id.textMyInfo5)
        anonymousboardBoard.setOnClickListener {
            Toast.makeText(this, "익명 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_anonymousboard::class.java)
            startActivity(intent)
        }

        val freeBoard = findViewById<TextView>(R.id.textMyInfo6)
        freeBoard.setOnClickListener {
            Toast.makeText(this, "자유 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_freeboard::class.java)
            startActivity(intent)
        }


        var bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)

        //var selectedItem: Int = R.id.item_board
       // if (savedInstanceState != null) {
        //    selectedItem = savedInstanceState.getInt("selectedItem", R.id.item_home)
        //}


        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            //bottomNavigationView.selectedItemId = selectedItem
            //selectedItem = item.itemId

            when (item.itemId) {
                R.id.item_menu -> {
                    // item_menu를 클릭했을 때 MenuActivity로 이동
                    val intent = Intent(this@Dep2_boards, Dep2_menu::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_profile -> {
                    // item_profile를 클릭했을 때 마이페이지로 이동

                    startActivity(intent)
                    val intent =Intent(this@Dep2_boards, Dep2_Mypage::class.java)
                    startActivity(intent)

                    true
                }
                R.id.item_chatting -> {
                    // item_chatting을 클릭했을 때 채팅으로 이동
                    val intent =Intent(this@Dep2_boards, Dep2_Chatting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_home -> {
                    // item_menu를 클릭했을 때 마이페이지로 이동
                    val intent =Intent(this@Dep2_boards, Dep1_Home::class.java)
                    startActivity(intent)
                    true
                }
                // 다른 항목에 대한 처리도 추가할 수 있습니다.
                else -> false
            }
        }



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