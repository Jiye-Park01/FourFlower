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

    }
}