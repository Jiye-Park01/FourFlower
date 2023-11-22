package com.example.ff_sdci

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date

class LoginActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiService = RetrofitInstance.apiService

        // 로그인 버튼 클릭 등의 이벤트에서 호출
        val user = User(
            user_id = 1L,
            user_name = "your_username",
            user_login_id = "your_login_id",
            user_pw = "your_password",
            user_phone = 1234567890L,
            user_nickname = "your_nickname",
            user_join_date = Date(),
            login_type = "your_login_type",
            family_token = 123L,
            disturb_id = 456L
        )

        val call: Call<String> = apiService.login(user)
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    // 서버에서 받은 결과에 따라 처리
                } else {
                    // 서버 응답이 실패한 경우 처리
                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                // 통신 실패 시 처리
            }
        })
    }
}
