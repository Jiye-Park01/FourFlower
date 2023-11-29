package com.example.ff_sdci.homefragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep3_CustomerService
import com.example.ff_sdci.Dep3_alarm
import com.example.ff_sdci.Dep3_notice
import com.example.ff_sdci.R
import com.example.fourflower.ProfillSet
import com.example.fourflower.scrap
import com.example.fourflower.your_wrote

class MypageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mypage, container, false)

        val back_button = view.findViewById<View>(R.id.back)
        back_button.setOnClickListener {
            val intent = Intent(requireContext(), Dep1_Home::class.java)
            startActivity(intent)
        }

        val profill = view.findViewById<LinearLayout>(R.id.profile)
        profill.setOnClickListener {
            Toast.makeText(requireContext(), "프로필 관리 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), ProfillSet::class.java)
            startActivity(intent)
        }

        val myWrite = view.findViewById<LinearLayout>(R.id.my_write)
        myWrite.setOnClickListener {
            Toast.makeText(requireContext(), "작성한 글 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), your_wrote::class.java)
            startActivity(intent)
        }

        val scrapw = view.findViewById<LinearLayout>(R.id.scrap)
        scrapw.setOnClickListener {
            Toast.makeText(requireContext(), "스크랩 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), scrap::class.java)
            startActivity(intent)
        }

        val alarm = view.findViewById<LinearLayout>(R.id.layout_3)
        alarm.setOnClickListener {
            Toast.makeText(requireContext(), "알림 버튼", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_alarm::class.java)
            startActivity(intent)
        }

        val FAQ = view.findViewById<LinearLayout>(R.id.FAQ)
        FAQ.setOnClickListener {
            Toast.makeText(requireContext(), "FAQ 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_CustomerService::class.java)
            startActivity(intent)
        }

        val notice = view.findViewById<LinearLayout>(R.id.Notice)
        notice.setOnClickListener {
            Toast.makeText(requireContext(), "공지사항 버튼 클릭", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_notice::class.java)
            startActivity(intent)
        }

        return view
    }
}
