package com.example.ff_sdci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Dep3_mycar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep3_mycar)
        val back_button: ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, Dep1_Home::class.java)
            startActivity(intent)
        }
    }
}