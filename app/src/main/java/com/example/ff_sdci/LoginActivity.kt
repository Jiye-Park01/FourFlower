package com.example.ff_sdci

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
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
    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.activity_login)


        val BackButton=findViewById<View>(R.id.back)
        val loginButton=findViewById<Button>(R.id.loginButton)

        val emailEditText = findViewById<EditText>(R.id.id_edit)
        val passwordEditText = findViewById<EditText>(R.id.password_edit)
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
            signIn(emailEditText.text.toString(), passwordEditText.text.toString())
        }
    }

    private fun signIn (id_edit:String, password_edit: String) {
        if (id_edit.isNotEmpty() && password_edit.isNotEmpty()) {
            auth?.signInWithEmailAndPassword(id_edit,password_edit)?.addOnCompleteListener(this) {task->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                    moveMainPage(auth?.currentUser)
                } else {
                    Toast.makeText(baseContext, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // 유저정보 넘겨주고 메인 엑티비티 호출
    fun moveMainPage(user: FirebaseUser?) {
        if (user!=null) {
            startActivity(Intent(this,Splash2::class.java))
            finish()
        }
    }
}