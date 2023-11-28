package com.example.ff_sdci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.ff_sdci.databinding.ActivityNaviBinding
import com.example.ff_sdci.HomeFragment
import com.example.ff_sdci.homefragment.BoardFragment
import com.example.ff_sdci.homefragment.MenuFragment
import com.example.ff_sdci.homefragment.MypageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG_HOME = "home_fragment"
private const val TAG_MENU = "menu_fragment"
private const val TAG_BOARD = "board_fragment"
private const val TAG_CHAT = "chat_fragment"
private const val TAG_MY_PAGE = "my_page_fragment"

class NaviActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dep1_Home 코드 참고하여 setFragment에 대한 로직 추가
        setFragment(TAG_HOME, HomeFragment())

        binding.navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_home -> setFragment(TAG_HOME, HomeFragment())
                R.id.item_menu -> setFragment(TAG_MENU, MenuFragment())
                R.id.item_board -> setFragment(TAG_BOARD, BoardFragment())
                R.id.item_chatting -> setFragment(TAG_CHAT, ChattingFragment())
                R.id.item_profile -> setFragment(TAG_MY_PAGE, MypageFragment())
            }
            true // 리스너에서 이벤트 처리를 완료했음을 나타내기 위해 true 반환
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null) {
            fragTransaction.add(R.id.main_layout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val menu = manager.findFragmentByTag(TAG_MENU)
        val board = manager.findFragmentByTag(TAG_BOARD)
        val chat = manager.findFragmentByTag(TAG_CHAT)
        val myPage = manager.findFragmentByTag(TAG_MY_PAGE)

        hideFragments(fragTransaction, home, menu, board, chat, myPage)

        when (tag) {
            TAG_HOME -> if (home != null) fragTransaction.show(home)
            TAG_MENU -> if (menu != null) fragTransaction.show(menu)
            TAG_BOARD -> if (board != null) fragTransaction.show(board)
            TAG_CHAT -> if (chat != null) fragTransaction.show(chat)
            TAG_MY_PAGE -> if (myPage != null) fragTransaction.show(myPage)
        }

        fragTransaction.commitAllowingStateLoss()
    }

    private fun hideFragments(
        transaction: FragmentTransaction,
        vararg fragments: Fragment?
    ) {
        for (fragment in fragments) {
            fragment?.let { transaction.hide(it) }
        }
    }
}
