package com.example.ff_sdci.homefragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ff_sdci.Dep1_Home
import com.example.ff_sdci.Dep3_disturbtime
import com.example.ff_sdci.Dep3_mycar
import com.example.ff_sdci.Dep3_ongoingvote
import com.example.ff_sdci.Dep4_search_car
import com.example.ff_sdci.Dep_disturbtime2ut
import com.example.ff_sdci.R

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val back_button = view.findViewById<View>(R.id.back)
        back_button.setOnClickListener {
            val intent = Intent(requireContext(), Dep1_Home::class.java)
            startActivity(intent)
        }

        val setDisturbTime = view.findViewById<View>(R.id.distrupt_1)
        setDisturbTime.setOnClickListener {
            Toast.makeText(requireContext(), "방해금지 시간 설정 창으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_disturbtime::class.java)
            startActivity(intent)
        }

        val disturbTime2UT = view.findViewById<View>(R.id.distrupt_2)
        disturbTime2UT.setOnClickListener {
            Toast.makeText(requireContext(), "이웃의 방해금지 시간 창으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep_disturbtime2ut::class.java)
            startActivity(intent)
        }

        val myCar = view.findViewById<View>(R.id.parking_1)
        myCar.setOnClickListener {
            Toast.makeText(requireContext(), "차량 등록 창으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_mycar::class.java)
            startActivity(intent)
        }

        val carSearch = view.findViewById<View>(R.id.parking_2)
        carSearch.setOnClickListener {
            Toast.makeText(requireContext(), "차량 검색 창으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep4_search_car::class.java)
            startActivity(intent)
        }

        val vote = view.findViewById<View>(R.id.vote_1)
        vote.setOnClickListener {
            Toast.makeText(requireContext(), "전자 투표 창으로 이동", Toast.LENGTH_SHORT).show()
            val intent = Intent(requireContext(), Dep3_ongoingvote::class.java)
            startActivity(intent)
        }

        return view
    }
}
