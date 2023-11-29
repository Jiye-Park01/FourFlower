package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ff_sdci.DB.User
import com.example.ff_sdci.databinding.ActivityLoginBinding
import com.example.ff_sdci.databinding.ActivityMembershipIdAndpasswordBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import kotlin.math.sign

class membership_idANDpassword : AppCompatActivity() {

    lateinit var binding: ActivityMembershipIdAndpasswordBinding  //추가한 부분
    lateinit var mAuth: FirebaseAuth // 추가

    private lateinit var mDbRef: DatabaseReference // 데이터 베이스 객체 생성


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMembershipIdAndpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 초기화 +추가한 코드
        mAuth=Firebase.auth

        // db 초기화
        mDbRef=Firebase.database.reference

        //버튼 이벤트 만듦 (추가)

        binding.signup.setOnClickListener {
            val name=binding.nameT.text.toString().trim()
            val email=binding.idT.text.toString().trim()
            val password=binding.passwordT.text.toString().trim()

            signUp(name, email,password)
        }




        // 계정 생성 버튼


    }

    /**
     * 회원 가입
     */
    private fun signUp(name: String, email:String, password:String) {
        mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {task->
                if(task.isSuccessful) {
                    // 성공시 실팽
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this@membership_idANDpassword, Splash2::class.java)
                    startActivity(intent)
                    addUserToDatabase(name,email,mAuth.currentUser?.uid!!)
                } else {
                    // 실패시 실행
                    Toast.makeText(this, "회원가입 실패", Toast.LENGTH_SHORT).show()

                }

            }
    }

    private fun addUserToDatabase(name:String, email:String, uId:String) {
        mDbRef.child("user").child(uId).setValue(User(name,email,uId))
    }


}