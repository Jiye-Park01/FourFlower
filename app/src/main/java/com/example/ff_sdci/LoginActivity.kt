package com.example.ff_sdci

import android.content.Intent
import android.hardware.biometrics.BiometricManager.Strings
import android.net.wifi.WifiConfiguration.Protocol.strings


import android.os.AsyncTask
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.Date




class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var loginButton: Button
    private lateinit var idEditText: EditText
    private lateinit var pwEditText: EditText

    interface ApiService {
        @FormUrlEncoded
        @POST("/FourFlowerServer/android")
        suspend fun login(@Field("id") id: String, @Field("pw") pw: String): String
    }

    private val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener(this)

        idEditText = findViewById(R.id.id_edit)
        pwEditText = findViewById(R.id.password_edit)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.loginButton -> login()
        }
    }

    private fun login() {
        Log.w("login", "로그인이 정상적으로 진행 중")
        try {
            val id = idEditText.text.toString()
            val pw = pwEditText.text.toString()
            Log.w("앱에서 보낸값", "$id, $pw")

            // 코루틴을 사용하여 비동기적으로 네트워크 호출
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val result = withContext(Dispatchers.IO) {
                        apiService.login(id, pw)
                    }
                    Log.w("받은 값", result)

                    // 바로 밑에줄 코드 수정요망
                    val intent = Intent(this@LoginActivity, Dep3_disturbtime::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
