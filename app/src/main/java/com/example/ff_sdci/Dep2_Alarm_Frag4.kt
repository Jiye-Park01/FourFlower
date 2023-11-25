package com.example.ff_sdci

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dep2_Alarm_Frag4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 이 프래그먼트의 레이아웃을 인플레이트합니다.
        val view = inflater.inflate(R.layout.fragment_dep2__alarm__frag4, container, false)

        // 레이아웃 내의 RecyclerView를 찾습니다.
        val board_recycler: RecyclerView = view.findViewById(R.id.board_recycler)

        // 코드 실행 순서를 추적하기 위한 로그
        Log.d("TAG", "onCreateView: post_list 생성 전")

        // 게시판 목록을 생성합니다.
        val alarmList = arrayListOf(
            OneAlarmView("방해금지모드", "제목", "내용"),
            OneAlarmView("방해금지모드", "제목1", "내용"),
            OneAlarmView("방해금지모드", "제목2", "내용")
        )

        // RecyclerView 설정
        val layoutManager = LinearLayoutManager(requireContext())
        board_recycler.layoutManager = layoutManager

        // 어댑터 생성 및 RecyclerView에 설정
        val adapter = OneAlarmAdapter(alarmList) // 여기서 YourAdapter를 실제 사용하는 어댑터 클래스로 바꿔주세요
        board_recycler.adapter = adapter

        return view
    }
}
