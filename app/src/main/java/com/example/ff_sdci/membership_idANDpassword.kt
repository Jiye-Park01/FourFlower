package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.math.sign

class membership_idANDpassword : AppCompatActivity() {
    private lateinit var id_t : EditText
    private lateinit var password_t: EditText
    private lateinit var signup : Button
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membership_id_andpassword)

        // 로그인 로직 구현
        id_t = findViewById(R.id.id_t)
        password_t=findViewById(R.id.password_t)
        signup= findViewById(R.id.signup)

        auth = FirebaseAuth.getInstance()

        // 계정 생성 버튼
        signup.setOnClickListener {
            val userid = id_t.text.toString()
            val userpass= password_t.text.toString()
            // 회원가입 버튼을 클릭했을 때 실행할 코드 작성
            auth.createUserWithEmailAndPassword(userid,userpass)
                .addOnCompleteListener(this) {
                    task ->
                    if(task.isSuccessful) {
                        // 회원가입 성공
                        Toast.makeText(this,"계정 생성 완료", Toast.LENGTH_SHORT).show()
                        finish() //가입창 종료
                    } else {
                        // 회원가입 실패
                        Toast.makeText(this,"계정 생성 실패", Toast.LENGTH_SHORT).show()
                        finish() //가입창 종료
                    }
                }

        }

    }


}