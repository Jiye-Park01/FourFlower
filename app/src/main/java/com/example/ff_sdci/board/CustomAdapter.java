package com.example.ff_sdci.board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ff_sdci.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Notice> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Notice> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 리스트뷰가 어댑터에 연결 후 뷰를 만들어냄
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_one_board, parent, false);
        CustomViewHolder holder=new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getProfile()) 이미지에 대한 처리 ㅇㅇ
//        .into(holder.iv_profile // 이미지에대한거 );

        holder.title_f.setText(arrayList.get(position).getTitle());
        holder.content_f.setText(arrayList.get(position).getContent());

    }

    @Override
    public int getItemCount() {

        // 3항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        // ImageView
        TextView title_f;
        TextView content_f;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title_f = itemView.findViewById(R.id.title_f);
            this.content_f=itemView.findViewById(R.id.content_f);
        }
    }
}
