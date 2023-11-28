package com.example.ff_sdci.homefragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ff_sdci.Dep3_popularboard
import com.example.ff_sdci.OneTitleView
import com.example.ff_sdci.OneTitleViewAdapter
import com.example.ff_sdci.R
import com.example.ff_sdci.board.Dep3_Noticeboard

class BoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_board, container, false)


        val boardRecycler1: RecyclerView = view.findViewById(R.id.board_recycler1)
        val boardRecycler2: RecyclerView = view.findViewById(R.id.board_recycler2)
        val boardRecycler3: RecyclerView = view.findViewById(R.id.board_recycler3)
        val boardRecycler4: RecyclerView = view.findViewById(R.id.board_recycler4)
        val boardRecycler5: RecyclerView = view.findViewById(R.id.board_recycler5)
        val boardRecycler6: RecyclerView = view.findViewById(R.id.board_recycler6)

        val titleList1 = arrayListOf(
            OneTitleView("제목 1"),
            OneTitleView("제목 2"),
            OneTitleView("제목 3"),
            OneTitleView("제목 4")
        )

        val titleList2 = arrayListOf(
            OneTitleView("제목 5"),
            OneTitleView("제목 6"),
            OneTitleView("제목 7"),
            OneTitleView("제목 8")
        )

        val titleList3 = arrayListOf(
            OneTitleView("제목 9"),
            OneTitleView("제목 10"),
            OneTitleView("제목 11"),
            OneTitleView("제목 12")
        )

        val titleList4 = arrayListOf(
            OneTitleView("제목 13"),
            OneTitleView("제목 14"),
            OneTitleView("제목 15"),
            OneTitleView("제목 16")
        )

        val titleList5 = arrayListOf(
            OneTitleView("제목 17"),
            OneTitleView("제목 18"),
            OneTitleView("제목 19"),
            OneTitleView("제목 20")
        )

        val titleList6 = arrayListOf(
            OneTitleView("제목 21"),
            OneTitleView("제목 22"),
            OneTitleView("제목 23"),
            OneTitleView("제목 24")
        )

        val boardAdapter1 = OneTitleViewAdapter(titleList1)
        boardRecycler1.adapter = boardAdapter1
        boardRecycler1.layoutManager = LinearLayoutManager(requireContext())

        val boardAdapter2 = OneTitleViewAdapter(titleList2)
        boardRecycler2.adapter = boardAdapter2
        boardRecycler2.layoutManager = LinearLayoutManager(requireContext())

        val boardAdapter3 = OneTitleViewAdapter(titleList3)
        boardRecycler3.adapter = boardAdapter3
        boardRecycler3.layoutManager = LinearLayoutManager(requireContext())

        val boardAdapter4 = OneTitleViewAdapter(titleList4)
        boardRecycler4.adapter = boardAdapter4
        boardRecycler4.layoutManager = LinearLayoutManager(requireContext())

        val boardAdapter5 = OneTitleViewAdapter(titleList5)
        boardRecycler5.adapter = boardAdapter5
        boardRecycler5.layoutManager = LinearLayoutManager(requireContext())

        val boardAdapter6 = OneTitleViewAdapter(titleList6)
        boardRecycler6.adapter = boardAdapter6
        boardRecycler6.layoutManager = LinearLayoutManager(requireContext())

        // 공지 게시판을 눌렀을 때 공지 게시판으로 이동
        val noticeBoard = view.findViewById<TextView>(R.id.textMyInfo1)
        noticeBoard.setOnClickListener {
            Toast.makeText(requireContext(), "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_Noticeboard::class.java)
            startActivity(intent)
        }
        // 인기 게시판을 눌렀을 때 인기 게시판으로 이동
        val popularBoard = view.findViewById<TextView>(R.id.textMyInfo2)
        popularBoard.setOnClickListener {
            Toast.makeText(requireContext(), "인기 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_popularboard::class.java)
            startActivity(intent)
        }
        // 홍보 게시판을 눌렀을 때 공지 게시판으로 이동
        val promotionBoard = view.findViewById<TextView>(R.id.textMyInfo3)
        promotionBoard.setOnClickListener {
            Toast.makeText(requireContext(), "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_Noticeboard::class.java)
            startActivity(intent)
        }

        // 장터 게시판을 눌렀을 때 공지 게시판으로 이동
        val marketBoard = view.findViewById<TextView>(R.id.textMyInfo4)
        marketBoard.setOnClickListener {
            Toast.makeText(requireContext(), "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_Noticeboard::class.java)
            startActivity(intent)
        }

        // 익명 게시판을 눌렀을 때 공지 게시판으로 이동
        val anonymousBoard = view.findViewById<TextView>(R.id.textMyInfo5)
        anonymousBoard.setOnClickListener {
            Toast.makeText(requireContext(), "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_Noticeboard::class.java)
            startActivity(intent)
        }

        // 자유 게시판을 눌렀을 때 공지 게시판으로 이동
        val freeBoard = view.findViewById<TextView>(R.id.textMyInfo6)
        freeBoard.setOnClickListener {
            Toast.makeText(requireContext(), "공지 게시판으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_Noticeboard::class.java)
            startActivity(intent)
        }



        return view
    }
}
