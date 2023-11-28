package com.example.ff_sdci

import android.app.Activity
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
import androidx.appcompat.widget.AppCompatImageButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import java.text.SimpleDateFormat
import java.util.*

class Dep4_write : AppCompatActivity() {

    private lateinit var title_et: EditText
    private lateinit var content_et: EditText
    private lateinit var photo_reg_button: ImageButton
    private lateinit var selectedImageUri: Uri
    private lateinit var storageReference: StorageReference
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep4_write)

        // Initialize Firebase Storage and Firestore
        storageReference = FirebaseStorage.getInstance().reference
        firestore = FirebaseFirestore.getInstance()

        title_et = findViewById(R.id.title_et)
        content_et = findViewById(R.id.content_et)
        photo_reg_button = findViewById(R.id.photo_button)
        photo_reg_button.setOnClickListener {
            // Open gallery to select an image
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        val reg_button = findViewById<ImageButton>(R.id.reg_button)
        reg_button.setOnClickListener {
            // Get user input
            val title = title_et.text.toString()
            val content = content_et.text.toString()

            // Save data to Firestore after image upload
            val imagesRef = storageReference.child("images/${selectedImageUri.lastPathSegment}")
            val uploadTask = imagesRef.putFile(selectedImageUri)

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
                    // Save data to Firestore with downloadUrl
                    val docData = hashMapOf(
                        "title" to title,
                        "content" to content,
                        "imageUrl" to downloadUrl.toString() // Store download URL in Firestore
                    )

                    firestore.collection("posts")
                        .add(docData)
                        .addOnSuccessListener {
                            Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "등록에 실패했습니다: $e", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    // Handle failures
                    Toast.makeText(this, "이미지 업로드 실패", Toast.LENGTH_SHORT).show()
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
