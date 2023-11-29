package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.ff_sdci.homefragment.BoardFragment
import com.google.firebase.firestore.FirebaseFirestore

class Dep4_my_post : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var contentTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep4_my_post)

        // 뷰 초기화
        imageView = findViewById(R.id.image_tv) // 여기서 imageView 초기화
        titleTextView = findViewById(R.id.title_tv)
        contentTextView = findViewById(R.id.content_tv)

        // 뒤로 가기 버튼 클릭 리스너
        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, BoardFragment::class.java)
            startActivity(intent)
        }

        // Firestore에서 데이터 검색 및 표시
        val postId = intent.getStringExtra("postId")
        if (postId != null) {
            val firestore = FirebaseFirestore.getInstance()
            val docRef = firestore.collection("posts").document(postId)
            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        val title = document.getString("title")
                        val content = document.getString("content")
                        val imageUrl = document.getString("imageUrl")

                        // 데이터 표시
                        titleTextView.text = title
                        contentTextView.text = content

                        // Glide 또는 Picasso를 사용하여 이미지 로드
                        if (imageUrl != null) {
                            Glide.with(this)
                                .load(imageUrl)
                                .into(imageView)
                        }
                    } else {
                        Log.d("ViewPostActivity", "해당 문서 없음")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d("ViewPostActivity", "데이터 검색 실패: ", exception)
                }
        }
    }
}
