package com.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private ImageView imageBack;
    private GridView gv;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();

        initData();

        setListener();
    }

    private void initView() {
        imageBack = (ImageView) findViewById(R.id.imageView_back);
        gv = (GridView) findViewById(R.id.gridView_search);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("A" + i);
        }
    }

    private void setListener() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        adapter = new ArrayAdapter<String>(this, R.layout.item_gridview_search, list);
        gv.setAdapter(adapter);
    }
}
