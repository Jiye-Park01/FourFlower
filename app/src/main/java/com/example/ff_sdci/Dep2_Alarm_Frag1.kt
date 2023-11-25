package com.example.ff_sdci
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dep2_Alarm_Frag1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dep2__alarm__frag1, container, false)

        // RecyclerView 찾기
        val boardRecycler: RecyclerView = view.findViewById(R.id.board_recycler)

        val alarmList = arrayListOf(
            OneAlarmView("게시판", "제목", "내용",),
            OneAlarmView("게시판", "제목1", "내용", )
        )

        // RecyclerView 설정
        val layoutManager = LinearLayoutManager(requireContext())
        boardRecycler.layoutManager = layoutManager

        // 어댑터 생성 및 RecyclerView에 설정
        val adapter = OneAlarmAdapter(alarmList)
        boardRecycler.adapter = adapter

        return view
    }
}
