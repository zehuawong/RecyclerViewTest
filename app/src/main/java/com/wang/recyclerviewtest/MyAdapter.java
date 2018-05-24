package com.wang.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Number>  numberList;

    private static final int ITEM_VIEW_ZERO=1;
    private static final int ITEM_VIEW_None_ZERO=0;

    static class ViewHolder extends RecyclerView.ViewHolder{
       TextView textView;
        public ViewHolder(View view){
            super(view);
            textView=(TextView)view.findViewById(R.id.item_tv);
        }
    }

    public MyAdapter(List<Number> numberList) {
        this.numberList = numberList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Number number=numberList.get(position);
                Toast.makeText(v.getContext(),"you clicked Textview:"+ number.value,Toast.LENGTH_SHORT).show();
            }
        });

        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Number number=numberList.get(position);
        holder.textView.setText(number.value+"");

    }

    @Override
    public int getItemViewType(int position) {
        return isZeroItem(position) ? ITEM_VIEW_ZERO : ITEM_VIEW_None_ZERO;
    }

    @Override
    public int getItemCount() {
        return numberList.size();
    }

    public boolean isZeroItem(int position){
        return (position+1)%3 == 0;
    }
}
