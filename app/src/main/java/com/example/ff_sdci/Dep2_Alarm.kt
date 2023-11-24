package com.example.ff_sdci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Dep2_Alarm : AppCompatActivity(), View.OnClickListener {

    private val FRAGMENT1 = 1
    private val FRAGMENT2 = 2

    private lateinit var bt_tab1: Button
    private lateinit var bt_tab2: Button
    private lateinit var bt_tab3: Button
    private lateinit var bt_tab4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep2_alarm)

        // 위젯에 대한 참조
        bt_tab1 = findViewById(R.id.bt_all)
        bt_tab2 = findViewById(R.id.bt_board)
        bt_tab3 = findViewById(R.id.bt_vote)
        bt_tab4 = findViewById(R.id.bt_distrupt)

        // 탭 버튼에 대한 리스너 연결
        bt_tab1.setOnClickListener(this)
        bt_tab2.setOnClickListener(this)
        bt_tab3.setOnClickListener(this)
        bt_tab4.setOnClickListener(this)

        // 임의로 액티비티 호출 시점에 어느 프레그먼트를 프레임레이아웃에 띄울 것인지를 정함
        callFragment(FRAGMENT1)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_all -> callFragment(FRAGMENT1)
            R.id.bt_board -> callFragment(FRAGMENT2)
        }
    }

    private fun callFragment(fragmentNo: Int) {
        // 프래그먼트 사용을 위해
        val transaction = supportFragmentManager.beginTransaction()

        when (fragmentNo) {
            1 -> {
                // '프래그먼트1' 호출
                val fragment1 = Dep2_Alarm_Frag1()
                transaction.replace(R.id.fragment_container, fragment1)
                transaction.commit()
            }
            2 -> {
                // '프래그먼트2' 호출
                val fragment2 = Dep2_Alarm_Frag2()
                transaction.replace(R.id.fragment_container, fragment2)
                transaction.commit()
            }
            3 -> {
                // '프래그먼트2' 호출
                val fragment3 = Dep2_Alarm_Frag3()
                transaction.replace(R.id.fragment_container, fragment3)
                transaction.commit()
            }
            4 -> {
                // '프래그먼트2' 호출
                val fragment4 = Dep2_Alarm_Frag4()
                transaction.replace(R.id.fragment_container, fragment4)
                transaction.commit()
            }
        }
    }
}



