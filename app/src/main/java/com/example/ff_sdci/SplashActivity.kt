package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT= 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //일정 시간이 지난 후에 다음 화면으로 전환하기 위해 Handler를 사용
        Handler().postDelayed({
            // 다음 화면으로 전환할 액티비티를 지정
            val intent = Intent(this, Splash2::class.java)
            startActivity(intent)
            finish() // 스플래시 화면 액티비티를 종료
        },SPLASH_TIME_OUT )
    }
}