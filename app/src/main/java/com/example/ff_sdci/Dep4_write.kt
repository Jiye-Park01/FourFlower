package com.example.ff_sdci

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import java.text.SimpleDateFormat
import java.util.*

class Dep4_write : AppCompatActivity() {

    private val TAG = javaClass.simpleName

    private lateinit var title_et: EditText
    private lateinit var content_et: EditText
    private lateinit var reg_button: ImageButton
    private lateinit var photo_button: ImageButton

    private var userid: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep4_write)

        userid = intent.getStringExtra("userid") ?: ""

        title_et = findViewById(R.id.title_et)
        content_et = findViewById(R.id.content_et)
        reg_button = findViewById(R.id.reg_button)
        photo_button = findViewById(R.id.photo_button)





        reg_button.setOnClickListener {
            // 게시물 등록
            val server_url = "http://15.164.252.136/reg_board.php" //서버 받으면 바꾸기

            // HttpURLConnection 객체를 생성합니다.
            val conn = URL(server_url).openConnection() as HttpURLConnection

            // 요청 메서드를 POST로 설정합니다.
            conn.requestMethod = "POST"

            // 전송할 데이터를 설정합니다.
            val builder = Uri.Builder()
                .appendQueryParameter("userid", userid)
                .appendQueryParameter("title", title_et.text.toString())
                .appendQueryParameter("content", content_et.text.toString())

            val query = builder.build().encodedQuery

            // 데이터를 전송합니다.
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            if (query != null) {
                conn.setRequestProperty("Content-Length", query.length.toString())
            }
            conn.doOutput = true
            if (query != null) {
                conn.outputStream.write(query.toByteArray())
            }

            // 응답을 수신합니다.
            val responseCode = conn.responseCode
            val response = if (responseCode == HttpsURLConnection.HTTP_OK) {
                conn.inputStream.bufferedReader().use { it.readText() }
            } else {
                ""
            }

            // 응답을 처리합니다.
            if (response == "success") {
                Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
