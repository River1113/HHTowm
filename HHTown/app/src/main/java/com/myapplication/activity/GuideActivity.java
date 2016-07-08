package com.myapplication.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.myapplication.R;
import com.myapplication.adapter.GuideAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导界面,仅在第一次登录时才显示
 */
public class GuideActivity extends AppCompatActivity {
    private ViewPager guidePager;
    private CirclePageIndicator indicator;
    private List<ImageView> imageViews;
    private GuideAdapter guideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();

        guidePager.setAdapter(guideAdapter); //绑定适配器

        indicator.setViewPager(guidePager);

        guidePager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (imageViews.size()-1  == position){
                    ((ImageView) imageViews.get(position)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(GuideActivity.this, MainActivity.class));
                            finish();
                        }
                    });
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     *  初始化控件及imageViews
     */
    public void initView() {
        guidePager = (ViewPager) findViewById(R.id.guide_pager);
        indicator = (CirclePageIndicator) findViewById(R.id.guide_indicator);
    }
    public void initData(){
        imageViews = new ArrayList<ImageView>();
        ImageView imageView1 = (ImageView) getLayoutInflater().inflate(R.layout.image_guide, null);
        imageView1.setImageResource(R.mipmap.guidepage1);

        imageViews.add(imageView1);
        ImageView imageView2 = (ImageView) getLayoutInflater().inflate(R.layout.image_guide, null);
        imageView2.setImageResource(R.mipmap.guidepage2);
        imageViews.add(imageView2);

        ImageView imageView3 = (ImageView) getLayoutInflater().inflate(R.layout.image_guide, null);
        imageView3.setImageResource(R.mipmap.guidepage3);
        imageViews.add(imageView3);

        ImageView imageView4 = (ImageView) getLayoutInflater().inflate(R.layout.image_guide, null);
        imageView4.setImageResource(R.mipmap.guidepage4);
        imageViews.add(imageView4);

        guideAdapter = new GuideAdapter(imageViews);

    }

    /**
     * 点击进入主界面
     * @param view
     */
    public void btnTurnClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
