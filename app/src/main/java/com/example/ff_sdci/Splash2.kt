package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Splash2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val mybutton=findViewById<Button>(R.id.IDLogin)
        mybutton.setOnClickListener {
            // 버튼이 클릭되었을 때 실행할 코드 작성
            Toast.makeText(this,"버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 버튼을 클릭했을 때
        val Signup=findViewById<Button>(R.id.SignUp)
        Signup.setOnClickListener {
            // 회원가입 버튼을 클릭했을 때 실행할 코드 작성
            Toast.makeText(this,"회원가입 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, join_membership::class.java)
            startActivity(intent)
        }

    }
}