package com.example.recyclerview_practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<String> mData = null;

    //아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;

        ViewHolder(View itemView){
            super(itemView);

            textView1 = itemView.findViewById(R.id.text1);
        }
    }

    //생성자에서 데이터 리스트 객체 전달받음
    Adapter(ArrayList<String> list){
        mData = list;
    }
    //onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        Adapter.ViewHolder vh = new Adapter.ViewHolder(view);

        return vh; // 뷰홀더 객체 vh 리턴
    }
    //onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int posiotion){
        String text = mData.get(posiotion);
        holder.textView1.setText(text);
    }

    //getItemCount() - 전체 데이터 갯수 리턴
    @Override
    public int getItemCount(){
        return mData.size();
    }

}
