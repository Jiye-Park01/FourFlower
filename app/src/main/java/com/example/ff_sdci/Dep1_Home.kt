package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.ff_sdci.Dep2.Dep2_Chatting
import com.example.ff_sdci.Dep2.Dep2_Mypage
import com.example.ff_sdci.Dep2.Dep2_menu
import com.example.ff_sdci.board.Dep3_Noticeboard

import com.google.android.material.bottomnavigation.BottomNavigationView

class Dep1_Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep1_home)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_menu -> {
                    // item_menu를 클릭했을 때 MenuActivity로 이동
                    val intent = Intent(this@Dep1_Home, Dep2_menu::class.java)
                    startActivity(intent)
                    true
                }
                // 게시판은 뭐가 잇는 게 업슨데..?
                R.id.item_board -> {
                    // item_board를 클릭했을 때 게시판으로 이동

                    startActivity(intent)
                    val intent =Intent(this@Dep1_Home, Dep2_boards::class.java)
                    startActivity(intent)

                    true
                }
                R.id.item_chatting -> {
                    // item_chatting을 클릭했을 때 채팅으로 이동
                    val intent =Intent(this@Dep1_Home, Dep2_Chatting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_profile -> {
                    // item_menu를 클릭했을 때 마이페이지로 이동
                    val intent =Intent(this@Dep1_Home, Dep2_Mypage::class.java)
                    startActivity(intent)
                    true
                }
                // 다른 항목에 대한 처리도 추가할 수 있습니다.
                else -> false
            }
        }
         // 알림 버튼을 눌렀을 때 알림 설정으로 이동
            val AlarmButton = findViewById<ImageButton>(R.id.alarm1)
            AlarmButton.setOnClickListener{
                Toast.makeText(this,"알림 설정으로 이동",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,Dep2_Alarm::class.java)
                startActivity(intent)
            }
         // 방해금지모드 버튼을 눌렀을 때 방해금지모드 설정으로 이동
            val DisturbButton= findViewById<ImageButton>(R.id.distrupt_button)
            DisturbButton.setOnClickListener {
                Toast.makeText(this,"방해금지 설정으로 이동",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,Dep3_disturbtime::class.java)
                startActivity(intent)
            }

        // 인기 게시판을 눌렀을 때 인기 게시판으로 이동
            val popularBoard=findViewById<RelativeLayout>(R.id.popular_board_)
            popularBoard.setOnClickListener {
                Toast.makeText(this,"인기 게시판으로 이동",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,Dep3_popularboard::class.java)
                startActivity(intent)

            }

            // 공지 게시판을 눌렀을 때 공지 게시판으로 이동
            val noticeBoard= findViewById<RelativeLayout>(R.id.notice_boardc)
            noticeBoard.setOnClickListener {
                Toast.makeText(this,"공지 게시판으로 이동",Toast.LENGTH_SHORT).show()
                val intent= Intent(this,
                    Dep3_Noticeboard::class.java)
                startActivity(intent)
            }
        // 전자투표 및 서명을 눌렀을 때 전자투표로 이동

            val onlinevote=findViewById<LinearLayout>(R.id.menu3)
            onlinevote.setOnClickListener {
                Toast.makeText(this,"전자투표 및 서명으로 이동",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Dep3_ongoingvote::class.java)
                startActivity(intent)
            }


    }
}