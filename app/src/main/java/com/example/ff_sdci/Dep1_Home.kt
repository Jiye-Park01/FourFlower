package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.ff_sdci.Dep2.Dep2_Chatting
import com.example.ff_sdci.Dep2.Dep2_menu
import com.example.fourflower.ProfillSet
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
//                R.id.item_board -> {
//                    // item_board를 클릭했을 때 게시판으로 이동
//                }
                R.id.item_chatting -> {
                    // item_chatting을 클릭했을 때 채팅으로 이동
                    val intent =Intent(this@Dep1_Home, Dep2_Chatting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_profile -> {
                    // item_menu를 클릭했을 때 마이페이지로 이동
                    val intent =Intent(this@Dep1_Home, ProfillSet::class.java)
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






    }
}