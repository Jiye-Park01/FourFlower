package com.example.ff_sdci

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Dep4_write : AppCompatActivity() {

    private lateinit var title_et: EditText // 제목 입력란
    private lateinit var content_et: EditText // 내용 입력란
    private lateinit var photo_reg_button: ImageButton // 사진 등록 버튼
    private var selectedImageUri: Uri? = null // 선택된 이미지 URI
    private lateinit var storageReference: StorageReference // Firebase Storage 참조
    private lateinit var firestore: FirebaseFirestore // Firestore 데이터베이스

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep4_write)

        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent = Intent(this, Dep3_popularboard::class.java)
            startActivity(intent)
        }

        // Firebase Storage 및 Firestore 초기화
        storageReference = FirebaseStorage.getInstance().reference
        firestore = FirebaseFirestore.getInstance()

        title_et = findViewById(R.id.title_et) // 제목 입력란 참조
        content_et = findViewById(R.id.content_et) // 내용 입력란 참조
        photo_reg_button = findViewById(R.id.photo_button) // 사진 등록 버튼 참조
        photo_reg_button.setOnClickListener {
            // 갤러리 열기를 통해 이미지 선택
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        val reg_button = findViewById<ImageButton>(R.id.reg_button)
        reg_button.setOnClickListener {
            // 사용자 입력 가져오기
            val title = title_et.text.toString()
            val content = content_et.text.toString()

            // 이미지가 선택되었는지 확인
            if (selectedImageUri != null) {
                // 이미지 업로드 후 Firestore에 데이터 저장
                val imagesRef = storageReference.child("images/${selectedImageUri!!.lastPathSegment}")
                val uploadTask = imagesRef.putFile(selectedImageUri!!)

                uploadTask.continueWithTask { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let {
                            throw it
                        }
                    }
                    imagesRef.downloadUrl
                }.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val downloadUrl = task.result
                        // 다운로드 URL을 포함하여 Firestore에 데이터 저장
                        val docData = hashMapOf(
                            "title" to title,
                            "content" to content,
                            "imageUrl" to downloadUrl.toString() // Firestore에 다운로드 URL 저장
                        )

                        firestore.collection("posts")
                            .add(docData)
                            .addOnSuccessListener { documentReference ->
                                Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()

                                // 등록된 글을 보여주는 Activity로 이동
                                val intent = Intent(this, Dep4_my_post::class.java)
                                intent.putExtra("postId", documentReference.id) // 보여줄 포스트 ID 전달
                                startActivity(intent)

                                finish()
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "등록에 실패했습니다: $e", Toast.LENGTH_SHORT).show()
                            }
                    } else {
                        // 실패 처리
                        Toast.makeText(this, "이미지 업로드 실패", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // 이미지가 선택되지 않았을 때의 처리
                // 이미지가 선택되지 않았을 때도 데이터를 저장
                val docData = hashMapOf(
                    "title" to title,
                    "content" to content
                    // 이미지가 없는 경우 여기에서 저장하지 않음
                )

                firestore.collection("posts")
                    .add(docData)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()

                        // 등록된 글을 보여주는 Activity로 이동
                        val intent = Intent(this, Dep4_my_post::class.java)
                        intent.putExtra("postId", documentReference.id) // 보여줄 포스트 ID 전달
                        startActivity(intent)

                        finish()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "등록에 실패했습니다: $e", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            selectedImageUri = data.data!!
        }
    }

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }
}
