package com.example.ff_sdci

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class Dep3_disturbtime : AppCompatActivity() {

    private lateinit var disturbSwitch: Switch // 방해금지모드 버튼
    private lateinit var startTimeButton: Button
    private lateinit var endTimeButton: Button

    // 요일을 나타내는 TextView와 그에 해당하는 View들, 눌렀을때 활성화되도록
    private lateinit var monTextView: TextView
    private lateinit var tuesTextView: TextView
    private lateinit var wenTextView: TextView
    private lateinit var thursTextView: TextView
    private lateinit var friTextView: TextView
    private lateinit var satTextView: TextView
    private lateinit var sunTextView: TextView

    private lateinit var monView: View
    private lateinit var tuesView: View
    private lateinit var wenView: View
    private lateinit var thursView: View
    private lateinit var friView: View
    private lateinit var satView: View
    private lateinit var sunView: View

    private val dayOfWeekSelected = booleanArrayOf(false, false, false, false, false, false, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dep3_disturbtime)

        disturbSwitch = findViewById(R.id.switch1)
        startTimeButton = findViewById(R.id.starttime)
        endTimeButton = findViewById(R.id.endtime)

        monTextView = findViewById(R.id.mon)
        tuesTextView = findViewById(R.id.tues)
        wenTextView = findViewById(R.id.wen)
        thursTextView = findViewById(R.id.thurs)
        friTextView = findViewById(R.id.fri)
        satTextView = findViewById(R.id.sat)
        sunTextView = findViewById(R.id.sun)

        monView = findViewById(R.id.mon)
        tuesView = findViewById(R.id.tues)
        wenView = findViewById(R.id.wen)
        thursView = findViewById(R.id.thurs)
        friView = findViewById(R.id.fri)
        satView = findViewById(R.id.sat)
        sunView = findViewById(R.id.sun)



        disturbSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //  startAlarm()
            } else {
                //  cancelAlarm()
            }
        }

        startTimeButton.setOnClickListener {
            // 시작 시간 설정
            showTimePickerDialog(startTimeButton)
        }
        endTimeButton.setOnClickListener {
            // 종료 시간 설정
            showTimePickerDialog(endTimeButton)
        }

        // 각 요일을 나타내는 TextView와 그에 해당하는 View에 클릭 이벤트 추가
        monView.setOnClickListener { toggleDayOfWeek(0, monTextView, monView) }
        tuesView.setOnClickListener { toggleDayOfWeek(1, tuesTextView, tuesView) }
        wenView.setOnClickListener { toggleDayOfWeek(2, wenTextView, wenView) }
        thursView.setOnClickListener { toggleDayOfWeek(3, thursTextView, thursView) }
        friView.setOnClickListener { toggleDayOfWeek(4, friTextView, friView) }
        satView.setOnClickListener { toggleDayOfWeek(5, satTextView, satView) }
        sunView.setOnClickListener { toggleDayOfWeek(6, sunTextView, sunView) }


//        private fun startAlarm() {
//            // 방해 금지 활성화 시 알람 설정 로직 추가
//        }
//
//        private fun cancelAlarm() {
//            // 방해 금지 비활성화 시 알람 취소 로직 추가
//        }

    }

    private fun showTimePickerDialog(button: Button) {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _: TimePicker, hourOfDay: Int, minute: Int ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                button.text = selectedTime
            },
            hourOfDay,
            minute,
            true // 24시간 형식 사용
        )

        timePickerDialog.show()

    }

    private fun toggleDayOfWeek(index: Int, textView: TextView, view: View) {
        dayOfWeekSelected[index] = !dayOfWeekSelected[index]
        updateDayOfWeekUI(index, textView, view)
    }

    private fun updateDayOfWeekUI(index: Int, textView: TextView, view: View) {
        if (dayOfWeekSelected[index]) {
            // 선택된 경우
            textView.setTextColor(resources.getColor(R.color.white))
            view.setBackgroundColor(resources.getColor(R.color.mainColor))
        } else {
            // 선택이 해제된 경우
            textView.setTextColor(resources.getColor(R.color.black))
            view.setBackgroundColor(resources.getColor(R.color.mainColor2))
        }
    }
}