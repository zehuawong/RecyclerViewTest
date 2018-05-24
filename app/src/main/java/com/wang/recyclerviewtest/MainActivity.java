package com.wang.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Number> numberList=new ArrayList<Number>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNumberList();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final MyAdapter adapter=new MyAdapter(numberList);
        recyclerView.setAdapter(adapter);

      /*  final GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);

        //如果整除3，则1列，否则2列
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                 return adapter.isZeroItem(position)? gridLayoutManager.getSpanCount() :1;
            }
        });

        recyclerView.setLayoutManager(gridLayoutManager);
        */



    }

    private void initNumberList(){
        for(int i=1;i<=100;i++){
            numberList.add(new Number(i));
        }
    }

}
