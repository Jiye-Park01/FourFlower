package com.example.fourflower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ff_sdci.DB.User
import com.example.ff_sdci.R
import com.example.ff_sdci.databinding.ActivityProfillSetBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class ProfillSet : AppCompatActivity() {

    lateinit var binding: ActivityProfillSetBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference // 데이터베이스 인증 서비스 객체

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfillSetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인증 초기화
        mAuth = Firebase.auth
        // db 초기화
        mDbRef = Firebase.database.reference

        // 현재 로그인한 사용자 정보 가져오기
        val currentUser = mAuth.currentUser

        if (currentUser != null) {
            val userId = currentUser.uid

            // db에서 해당 사용자 정보 갖고 오기
            mDbRef.child("user").child(userId).addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // 데이터가 변경되었을 때
                    val currentUser = snapshot.getValue(User::class.java)
                    if (currentUser != null) {
                        // 사용자의 닉네임을 가져와서 뷰 업데이트
                        updateNickname(currentUser.name)

                        // 사용자의 이메일을 가져와서 뷰 업데이트
                        updateEmail(currentUser.email)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // 캔슬됐을 때, 실패했을 때 어떻게 실행할건지
                }
            })
        }
    }

    private fun updateNickname(nickname: String) {
        // 닉네임을 사용하여 뷰 업데이트 로직을 작성
        // 예: binding.nicknameTextView.text = nickname
        binding.nameText.text= nickname
    }

    private fun updateEmail(email: String) {
        // 이메일을 사용하여 뷰 업데이트 로직을 작성
        // 예: binding.emailTextView.text = email
        binding.emailtext.text=email
    }
}
