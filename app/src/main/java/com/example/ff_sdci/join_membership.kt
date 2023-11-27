package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class join_membership : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_membership)
        // 아이디와 비밀번호로 회원가입 버튼 클릭

        val idSignup=findViewById<Button>(R.id.id_and_passjoin)
        idSignup.setOnClickListener {
            // 회원가입 버튼을 클릭했을 때 실행할 코드 작성
            Toast.makeText(this,"회원가입 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, membership_idANDpassword::class.java)
            startActivity(intent)
        }
    }
}