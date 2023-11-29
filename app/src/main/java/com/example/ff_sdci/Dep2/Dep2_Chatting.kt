package com.example.ff_sdci.Dep2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ff_sdci.DB.User
import com.example.ff_sdci.DB.UserAdapter

import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep2_boards
import com.example.ff_sdci.R
import com.example.ff_sdci.R.id.dep2_chatRecycler
import com.example.ff_sdci.databinding.ActivityDep2ChattingBinding
import com.example.ff_sdci.databinding.ActivityProfillSetBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase



class Dep2_Chatting : AppCompatActivity() {

    lateinit var binding: ActivityDep2ChattingBinding
    lateinit var adapter: UserAdapter

    lateinit var mAuth: FirebaseAuth
    lateinit var mDbRef: DatabaseReference

    lateinit var userList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDep2ChattingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 인증 초기화
        mAuth = Firebase.auth

        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }




        // db 초기화
        mDbRef = Firebase.database.reference

        // 리스트 초기화
        userList = ArrayList()

        // 어댑터 초기화
        adapter = UserAdapter(this, userList)

        binding.dep2ChatRecycler.layoutManager = LinearLayoutManager(this)
        binding.dep2ChatRecycler.adapter = adapter

        // 사용자 정보 가져오기
        mDbRef.child("user").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // 데이터가 변경될 때마다
                for (postSnapshot in snapshot.children) {
                    // 유저 정보
                    val currentUser = postSnapshot.getValue(User::class.java)

                    if (mAuth.currentUser?.uid != currentUser?.uId) {
                        userList.add(currentUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // 실패 시 실행
            }
        })
    }
}
