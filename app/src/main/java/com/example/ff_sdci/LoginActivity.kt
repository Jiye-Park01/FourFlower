package com.example.ff_sdci

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST



class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val BackButton=findViewById<View>(R.id.back)
        val loginButton=findViewById<Button>(R.id.loginButton)
        BackButton.setOnClickListener {
            // 버튼이 클릭되었을 때 실행할 코드 작성
            Toast.makeText(this,"뒤로가기 버튼", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Splash2::class.java)
            startActivity(intent)
        }
        // 로그인 버튼 임시 처리 코드
        loginButton.setOnClickListener {
            // 로그인 버튼이 클릭되었을 때
            Toast.makeText(this,"로그인 버튼 클릭, 수정해야함", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }
    }
}