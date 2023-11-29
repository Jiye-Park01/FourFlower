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
import com.example.ff_sdci.databinding.ActivityDep1HomeBinding
import com.example.ff_sdci.databinding.ActivityLoginBinding
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
    lateinit var binding: ActivityLoginBinding // 추가
    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater) //추가
        setContentView(binding.root)

        // 인증 초기화
        mAuth= Firebase.auth



        // 로그인 버튼 이벤트
        binding.loginButton.setOnClickListener {
            val email=binding.idEdit.text.toString()
            val password= binding.passwordEdit.text.toString()

            login(email,password)
        }



    }

    /**
     * 로그인 기능
     */

    private fun login(email:String, password:String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                   // 성공 시 실팽
                    val intent= Intent(this@LoginActivity, Dep1_Home::class.java)

                    startActivity(intent)
                    Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    // 실패 시 실행
                    Toast.makeText(this,"로그인 실패",Toast.LENGTH_SHORT).show()
                    Log.d("Login", "Error:${task.exception}")


                }
            }

    }

}