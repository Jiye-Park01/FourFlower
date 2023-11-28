package com.example.ff_sdci.Dep2

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep2_boards
import com.example.ff_sdci.Dep3_disturbtime
import com.example.ff_sdci.Dep3_mycar
import com.example.ff_sdci.Dep3_ongoingvote
import com.example.ff_sdci.Dep4_search_car
import com.example.ff_sdci.Dep_disturbtime2ut
import com.example.ff_sdci.R
import com.google.android.material.bottomnavigation.BottomNavigationView

// 메뉴.
class Dep2_menu : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_menu)

        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)

        val menu = bottomNavigationView.menu

// 두 번째 아이템을 찾습니다.
        val secondItem = menu.getItem(1)

// 찾은 아이템의 아이콘 색상을 변경합니다.
        secondItem.iconTintList = ContextCompat.getColorStateList(this, R.color.mainColor)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_profile -> {
                    // item_profile을 클릭했을 때 마이페이지로 이동
                    val intent = Intent(this@Dep2_menu, Dep1_Home::class.java)
                    startActivity(intent)
                    true
                }
                // 게시판은 뭐가 잇는 게 업슨데..?
                R.id.item_board -> {
                    // item_board를 클릭했을 때 게시판으로 이동

                    startActivity(intent)
                    val intent =Intent(this@Dep2_menu, Dep2_boards::class.java)
                    startActivity(intent)

                    true
                }
                R.id.item_chatting -> {
                    // item_chatting을 클릭했을 때 채팅으로 이동
                    val intent =Intent(this@Dep2_menu, Dep2_Chatting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_home -> {
                    // item_home를 클릭했을 때 홈으로 이동
                    val intent =Intent(this@Dep2_menu, Dep1_Home::class.java)
                    startActivity(intent)
                    true
                }
                // 다른 항목에 대한 처리도 추가할 수 있습니다.
                else -> false
            }
        }

        // 방해금지 시간
        // 1. 방해금지 시간 설정 창으로 넘어가기
        val setdisturbtime=findViewById<View>(R.id.distrupt_1)
        setdisturbtime.setOnClickListener{
            Toast.makeText(this,"방해금지 시간 설정 창으로 이동",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, Dep3_disturbtime::class.java)
            startActivity(intent)
        }
        // 2. 이웃의 방해금지 시간 창응로 넘어가기
        val disturbtime2ut=findViewById<View>(R.id.distrupt_2)
        disturbtime2ut.setOnClickListener{
            Toast.makeText(this,"이웃의 방해금지 시간 창으로 이동",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, Dep_disturbtime2ut::class.java)
            startActivity(intent)
        }

        // 주차
        // 1. 차량 등록 창으로 넘어가기
        val mycar=findViewById<View>(R.id.parking_1)
        mycar.setOnClickListener{
            Toast.makeText(this,"차량 등록 창으로 이동",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, Dep3_mycar::class.java)
            startActivity(intent)
        }
        // 2. 차량 검색 창으로 넘어가기
        var carsearch=findViewById<View>(R.id.parking_2)
        carsearch.setOnClickListener{
            Toast.makeText(this,"차량 검색 창으로 이동",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, Dep4_search_car::class.java)
            startActivity(intent)
        }

        // 3. 전자투표 및 서명
        var Vote=findViewById<View>(R.id.vote_1)
        Vote.setOnClickListener{
            Toast.makeText(this,"전자 투표 창으로 이동",Toast.LENGTH_SHORT).show()
            val intent= Intent(this, Dep3_ongoingvote::class.java)
            startActivity(intent)
        }

        // 온라인 서명 -> 이거는 뭐랑 연결되는 거였죠..?
//        val Sign=findViewById<View>(R.id.vote_2)
//        Sign.setOnClickListener{
//            Toast.makeText(this,"온라인 서명 창으로 이동",Toast.LENGTH_SHORT).show()
//            val intent= Intent(this, ::class.java)
//            startActivity(intent)
//        }





    }


}