package com.example.ff_sdci.Dep2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.ff_sdci.DB.User
//import com.example.ff_sdci.DB.UserAdapter

import androidx.core.content.ContextCompat
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep2_boards

import com.example.ff_sdci.Dep3_CustomerService
import com.example.ff_sdci.Dep3_alarm
import com.example.ff_sdci.Dep3_notice
import com.example.ff_sdci.LoginActivity
import com.example.ff_sdci.R
import com.example.ff_sdci.R.id.my_write
import com.example.ff_sdci.databinding.ActivityDep2MypageBinding
import com.example.fourflower.ProfillSet
import com.example.fourflower.scrap
import com.example.fourflower.your_wrote

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.android.material.bottomnavigation.BottomNavigationView



// DatabaseReference를 확장하는 addChildEventListener 함수 정의
fun DatabaseReference.addChildEventListener(valueEventListener: ChildEventListener) {
    this.addChildEventListener(valueEventListener)
}




class Dep2_Mypage : AppCompatActivity() {

        lateinit var binding: ActivityDep2MypageBinding
       // lateinit var adapter: UserAdapter

        private lateinit var mAuth: FirebaseAuth
        private lateinit var mDbRef: DatabaseReference // 데이터베이스 인증 서비스 객체

        private lateinit var userList: ArrayList<User> //데이터를 담을 유저리스트

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDep2MypageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 인증 초기화
         mAuth= Firebase.auth
        // db 초기화
        mDbRef= Firebase.database.reference


        // 리스트 초기화
        userList= ArrayList()

        // 어댑터 초기화
        //adapter= UserAdapter(this,userList)
        // 현재 로그인한 사용자 정보 가져오기
        val currentUser = mAuth.currentUser
        // db 에서 사용자 정보 갖고 오기
        // db에서 사용자 정보 갖고 오기
        // db에서 사용자 정보 갖고 오기
        mDbRef.child("user").addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                // 데이터가 추가되었을 때
                val currentUser = snapshot.getValue(User::class.java)
                if (currentUser != null) {
                    userList.add(currentUser)
                    //adapter.notifyDataSetChanged()

                    // 닉네임을 사용하여 뷰 업데이트
                    updateNickname(currentUser.name)
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // 데이터가 변경되었을 때
                val updatedUser = snapshot.getValue(User::class.java)
                if (updatedUser != null) {
                    // 사용자 정보가 변경되었을 때 어댑터를 다시 설정하고, 뷰 업데이트
                    userList.clear()
                    userList.add(updatedUser)
                    //adapter.notifyDataSetChanged()
                    updateNickname(updatedUser.name)
                }
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                // 데이터가 삭제되었을 때
                // 삭제된 사용자를 어댑터에서 제거하고, 뷰 업데이트
                val removedUser = snapshot.getValue(User::class.java)
                if (removedUser != null) {
                    userList.remove(removedUser)
                    //adapter.notifyDataSetChanged()
                    // 여기에서는 닉네임 업데이트가 필요하지 않을 수 있습니다.
                }
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // 데이터가 이동되었을 때
                // 이동된 데이터에 대한 처리를 추가할 수 있습니다.
            }

            override fun onCancelled(error: DatabaseError) {
                // 캔슬됐을 때, 실패했을 때 어떻게 실행할건지
            }
        })

        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }

        var selectedItem: Int = R.id.item_profile
        if (savedInstanceState != null) {
            selectedItem = savedInstanceState.getInt("selectedItem", R.id.item_home)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            for (i in 0 until bottomNavigationView.menu.size()) {
                bottomNavigationView.menu.getItem(i).icon?.setTint(ContextCompat.getColor(this, R.color.mainColor))
            }

            // 선택된 아이템의 색상 변경
            item.icon?.setTint(ContextCompat.getColor(this, R.color.mainColor2))

            when (item.itemId) {
                R.id.item_menu -> {
                    // item_menu를 클릭했을 때 MenuActivity로 이동
                    val intent = Intent(this@Dep2_Mypage, Dep2_menu::class.java)
                    startActivity(intent)
                    true
                }
                // 게시판은 뭐가 잇는 게 업슨데..?
                R.id.item_board -> {
                    // item_board를 클릭했을 때 게시판으로 이동

                    startActivity(intent)
                    val intent =Intent(this@Dep2_Mypage, Dep2_boards::class.java)
                    startActivity(intent)

                    true
                }
                R.id.item_chatting -> {
                    // item_chatting을 클릭했을 때 채팅으로 이동
                    val intent =Intent(this@Dep2_Mypage, Dep2_Chatting::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_home -> {
                    // item_home를 클릭했을 때 홈으로 이동
                    val intent =Intent(this@Dep2_Mypage, Dep1_Home::class.java)
                    startActivity(intent)
                    true
                }
                // 다른 항목에 대한 처리도 추가할 수 있습니다.
                else -> false
            }
        }


        // 내 정보
        // 프로필 관리 누르면 프로필로 넘어감

        val profill=findViewById<LinearLayout>(R.id.profile)
        profill.setOnClickListener {
            // 버튼이 클릭되었을 때 실행할 코드 작성
            Toast.makeText(this,"프로필 관리 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProfillSet::class.java)
            startActivity(intent)
        }
        // 나의 글
        // 1. 작성한 글 , 작성한 글을 누르면 작성한 글 페이지로 넘어간다.
        val my_write=findViewById<LinearLayout>(R.id.my_write)
        my_write.setOnClickListener{
            Toast.makeText(this,"작성한 글 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, your_wrote::class.java)
            startActivity(intent)
        }
        // 2. 스크랩한 글. 누르면 스크랩 관리로 넘어감
        val scrapw=findViewById<LinearLayout>(R.id.scrap)
        scrapw.setOnClickListener {
            Toast.makeText(this,"스크랩 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, scrap::class.java)
            startActivity(intent)
        }

        // 설정
        // 1. 알림
        val alarm=findViewById<LinearLayout>(R.id.layout_3)
        alarm.setOnClickListener {
            Toast.makeText(this,"알림 버튼", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_alarm::class.java)
            startActivity(intent)
        }

        // 고객센터
        // 1. FAQ
        val FAQ=findViewById<LinearLayout>(R.id.FAQ)
        FAQ.setOnClickListener {
            Toast.makeText(this,"FAQ 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_CustomerService::class.java)
            startActivity(intent)
        }
        // 2. 공지사항
        val notice=findViewById<LinearLayout>(R.id.Notice)
        notice.setOnClickListener {
            Toast.makeText(this,"공지사항 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Dep3_notice::class.java)
            startActivity(intent)
        }


    }

    private fun updateNickname(nickname: String) {
        // 닉네임을 사용하여 뷰 업데이트 로직을 작성
        // 예: binding.nicknameTextView.text = nickname
        binding.nameText.text= nickname
    }
}