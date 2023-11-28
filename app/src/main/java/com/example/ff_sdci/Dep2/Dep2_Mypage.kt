package com.example.ff_sdci.Dep2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep2_boards
import com.example.ff_sdci.Dep3_CustomerService
import com.example.ff_sdci.Dep3_alarm
import com.example.ff_sdci.Dep3_notice
import com.example.ff_sdci.LoginActivity
import com.example.ff_sdci.R
import com.example.ff_sdci.R.id.my_write
import com.example.fourflower.ProfillSet
import com.example.fourflower.scrap
import com.example.fourflower.your_wrote
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dep2_Mypage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_mypage)

        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_menu -> {
                    // item_menu를 클릭했을 때 MenuActivity로 이동
                    val intent = Intent(this@Dep2_Mypage, Dep2_menu::class.java)
                    startActivity(intent)
                    true
                }
                // 게시판은 뭐가 잇는 게 업슨데..?
                R.id.item_board -> {
                    // item_board를 클릭했을 때 게시판으로 이동

                    startActivity(intent)
                    val intent =Intent(this@Dep2_Mypage, Dep2_boards::class.java)
                    startActivity(intent)

                    true
                }
                R.id.item_chatting -> {
                    // item_chatting을 클릭했을 때 채팅으로 이동
                    val intent =Intent(this@Dep2_Mypage, Dep2_Chatting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_home -> {
                    // item_home를 클릭했을 때 홈으로 이동
                    val intent =Intent(this@Dep2_Mypage, Dep1_Home::class.java)
                    startActivity(intent)
                    true
                }
                // 다른 항목에 대한 처리도 추가할 수 있습니다.
                else -> false
            }
        }

        // 내 정보
        // 프로필 관리 누르면 프로필로 넘어감

        val profill=findViewById<LinearLayout>(R.id.profile)
        profill.setOnClickListener {
            // 버튼이 클릭되었을 때 실행할 코드 작성
            Toast.makeText(this,"프로필 관리 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProfillSet::class.java)
            startActivity(intent)
        }
        // 나의 글
        // 1. 작성한 글 , 작성한 글을 누르면 작성한 글 페이지로 넘어간다.
        val my_write=findViewById<LinearLayout>(R.id.my_write)
        my_write.setOnClickListener{
            Toast.makeText(this,"작성한 글 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, your_wrote::class.java)
            startActivity(intent)
        }
        // 2. 스크랩한 글. 누르면 스크랩 관리로 넘어감
        val scrapw=findViewById<LinearLayout>(R.id.scrap)
        scrapw.setOnClickListener {
            Toast.makeText(this,"스크랩 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, scrap::class.java)
            startActivity(intent)
        }

        // 설정
        // 1. 알림
        val alarm=findViewById<LinearLayout>(R.id.layout_3)
        alarm.setOnClickListener {
            Toast.makeText(this,"알림 버튼", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_alarm::class.java)
            startActivity(intent)
        }

        // 고객센터
        // 1. FAQ
        val FAQ=findViewById<LinearLayout>(R.id.FAQ)
        FAQ.setOnClickListener {
            Toast.makeText(this,"FAQ 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_CustomerService::class.java)
            startActivity(intent)
        }
        // 2. 공지사항
        val notice=findViewById<LinearLayout>(R.id.Notice)
        notice.setOnClickListener {
            Toast.makeText(this,"공지사항 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_notice::class.java)
            startActivity(intent)
        }


    }
}