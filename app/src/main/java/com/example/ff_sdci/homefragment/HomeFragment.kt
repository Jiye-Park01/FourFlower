package com.example.ff_sdci.homefragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep2_Alarm
import com.example.ff_sdci.Dep3_disturbtime
import com.example.ff_sdci.Dep3_popularboard
import com.example.ff_sdci.R
import com.example.ff_sdci.board.Dep3_Noticeboard


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        // 알림 버튼을 눌렀을 때 알림 설정으로 이동
        val alarmButton = view.findViewById<ImageButton>(R.id.alarm1)
        alarmButton.setOnClickListener{
            Toast.makeText(requireContext(), "알림 설정으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep2_Alarm::class.java)
            startActivity(intent)
        }

        // 방해금지모드 버튼을 눌렀을 때 방해금지모드 설정으로 이동
        val disturbButton = view.findViewById<ImageButton>(R.id.distrupt_button)
        disturbButton.setOnClickListener {
            Toast.makeText(requireContext(), "방해금지 설정으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_disturbtime::class.java)
            startActivity(intent)
        }

        // 인기 게시판을 눌렀을 때 인기 게시판으로 이동
        val popularBoard = view.findViewById<RelativeLayout>(R.id.popular_board_)
        popularBoard.setOnClickListener {
            Toast.makeText(requireContext(), "인기 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_popularboard::class.java)
            startActivity(intent)
        }

        // 공지 게시판을 눌렀을 때 공지 게시판으로 이동
        val noticeBoard = view.findViewById<RelativeLayout>(R.id.notice_boardc)
        noticeBoard.setOnClickListener {
            Toast.makeText(requireContext(), "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_Noticeboard::class.java)
            startActivity(intent)
        }

        return view
    }
}