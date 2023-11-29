package com.example.ff_sdci.DB

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import com.example.ff_sdci.Dep3.Dep3_chatiing
import com.example.ff_sdci.R
import org.w3c.dom.Text

class UserAdapter(private val context: Context, private val userList:ArrayList<User>) :
RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    /**
     * 화면 설정
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       // Dep2_chatting 설정함
        val view: View= LayoutInflater.from(context)
            .inflate(R.layout.dep2_chatting_list_item,parent,false)

        return UserViewHolder(view)

    }

    /**
     *  리스트 개수 돌려주기
     */

    override fun getItemCount(): Int {
        // 리스트의 갯수를 돌려줌
        return userList.size
    }

    /**
     * 데이터 설정
     */

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // 데이터를 연결해줌

        val currentUser =userList[position]
        holder.nameText.text=currentUser.name

            // 아이템 클릭 이벤트
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Dep3_chatiing::class.java)

            // 넘길 데이터
            intent.putExtra("name",currentUser.name)
            intent.putExtra("uId",currentUser.uId)

            context.startActivity(intent)
        }
    }

    class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        // 이 클래스를 통해 뷰를 전달받아 유저 프로필 생성

        val nameText: TextView=itemView.findViewById(R.id.chatRoomTitle)
    }
}