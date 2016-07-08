package com.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;

public class CategoryActivity extends AppCompatActivity {
    private TextView title;
    private ImageView imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initView();
        initData();
        setListener();

    }

    private void initView() {
        title = (TextView) findViewById(R.id.title_category);
        imageBack = (ImageView) findViewById(R.id.imageView_back_category);
    }

    private void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        title.setText(name);
    }

    private void setListener() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}
