package com.wang.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Number>  numberList;

    private static final int ITEM_VIEW_ZERO=1;
    private static final int ITEM_VIEW_None_ZERO=0;

    private static class ZeroViewHolder extends RecyclerView.ViewHolder{
       TextView textView;
        public ZeroViewHolder(View view){
            super(view);
            textView=(TextView)view.findViewById(R.id.item_tv);
        }
    }


    private static class NoneZeroViewHolder extends RecyclerView.ViewHolder{
        TextView left_tv;
        TextView right_tv;
        public NoneZeroViewHolder(View view){
            super(view);
           left_tv=(TextView)view.findViewById(R.id.item_left_tv);
           right_tv=(TextView)view.findViewById(R.id.item_right_tv);
        }
    }



    public MyAdapter(List<Number> numberList) {
        this.numberList = numberList;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater minflater=LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder=null;
        if(viewType==ITEM_VIEW_ZERO){
             View view= minflater.inflate(R.layout.item_zero_tv,parent,false);
             holder=new ZeroViewHolder(view);

        }
        else {
             View view= minflater.inflate(R.layout.item_none_zero_tv,parent,false);
             holder=new NoneZeroViewHolder(view);
        }
        return holder;

      /*
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zero_tv,parent,false);
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
        */

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ZeroViewHolder){
            Number number=numberList.get((position+1)/2*3-1);
            ((ZeroViewHolder)holder).textView.setText(number.value+"");
        }
        else{
            Number number=numberList.get((position+1)*3/2-1);
            ((NoneZeroViewHolder)holder).left_tv.setText(number.value+"");
            ((NoneZeroViewHolder)holder).right_tv.setText((number.value+1)+"");
        }

    }

    @Override
    public int getItemViewType(int position) {
        return position%2==0 ? ITEM_VIEW_None_ZERO : ITEM_VIEW_ZERO;
    }

    @Override
    public int getItemCount() {
        //return numberList.size()%2==0 ? numberList.size()/2+1 : numberList.size()/2+2;
        return numberList.size()%3==0 ? numberList.size()/3*2 : numberList.size()/3*2+1;
    }

    public boolean isZeroItem(int position){
        return (position+1)%3 == 0;
    }
}
