package com.example.ff_sdci

<<<<<<< HEAD
import android.content.Intent
=======
>>>>>>> 2a332563b903441c8245306123582c8d24cf5a93
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
<<<<<<< HEAD
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Dep3_popularboard : AppCompatActivity() {


=======

class Dep3_popularboard : AppCompatActivity() {

>>>>>>> 2a332563b903441c8245306123582c8d24cf5a93
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep3_popularboard)

<<<<<<< HEAD
        val writeButton: FloatingActionButton = findViewById(R.id.write_button)
        writeButton.setOnClickListener {
            startActivity(Intent(this@Dep3_popularboard, Dep4_write::class.java))
        }

        val back_button : ImageView = findViewById(R.id.back)
        back_button.setOnClickListener {
            val intent: Intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        }



=======
>>>>>>> 2a332563b903441c8245306123582c8d24cf5a93
        val board_recycler: RecyclerView = findViewById(R.id.board_recycler)

        // Log를 추가하여 코드 실행 순서를 확인합니다.
        Log.d("TAG", "onCreate: Before post_list creation")

        val post_list = arrayListOf(
<<<<<<< HEAD
            OnePostView("제목1", "내용", R.drawable.h_thumbs, R.drawable.j_time,
                10, System.currentTimeMillis(), R.drawable.j_bookmark, R.drawable.h_testimg ),
            OnePostView("제목2", "내용", R.drawable.h_thumbs, R.drawable.j_time,
            10, System.currentTimeMillis(),   R.drawable.j_bookmark,R.drawable.h_testimg ),
                    OnePostView("제목2", "내용", R.drawable.h_thumbs, R.drawable.j_time,
            10, System.currentTimeMillis(),   R.drawable.j_bookmark,R.drawable.h_testimg ),
            OnePostView("제목2", "내용", R.drawable.h_thumbs, R.drawable.j_time,
                10, System.currentTimeMillis(),   R.drawable.j_bookmark,R.drawable.h_testimg ),
            OnePostView("제목2", "내용", R.drawable.h_thumbs, R.drawable.j_time,
                10, System.currentTimeMillis(),   R.drawable.j_bookmark,R.drawable.h_testimg )
=======
            OnePostView("제목1", "내용", R.drawable.h_thumbs, 2,
                R.drawable.j_time, R.drawable.j_bookmark, R.drawable.h_testimg, System.currentTimeMillis()),
            OnePostView("제목2", "내용", R.drawable.h_thumbs, 2,
                R.drawable.j_time, R.drawable.j_bookmark, R.drawable.h_testimg, System.currentTimeMillis())
>>>>>>> 2a332563b903441c8245306123582c8d24cf5a93
        )

        // Log를 추가하여 코드 실행 순서를 확인합니다.
        Log.d("TAG", "onCreate: Before boardAdapter creation")

        val boardAdapter = OnePostViewAdapter(post_list)
        board_recycler.adapter = boardAdapter
        board_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Log를 추가하여 코드 실행 순서를 확인합니다.
        Log.d("TAG", "onCreate: After boardAdapter setup")
    }
}