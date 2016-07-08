package com.myapplication.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.myapplication.Bean.MainTabEntity;
import com.myapplication.R;
import com.myapplication.fragment.SortFragment;
import com.myapplication.fragment.FindFragment;
import com.myapplication.fragment.HomeFragment;
import com.myapplication.fragment.MineFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private ImageView ivSearch, ivTitle, ivMore, ivCart;
    private TextView tvTitle;
    private PopupWindow popupWindow;
    private boolean isShow = true;

    private LinearLayout weChatLayout, inviteLayout, feedbackLayout, settingLayout;

    public static CommonTabLayout mTabLayout;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"首页", "分类", "发现", "我的"};
    private int[] mIconUnselectIds, mIconSelectIds;

    //tab的标题、选中图标、未选中图标
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();

        setListener();
    }

    /**
     * 初始化数据源
     */
    private void initData() {
        mFragments.add(new HomeFragment());
        mFragments.add(new SortFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MineFragment());
        mIconUnselectIds = new int[]{
                R.mipmap.menu_home_first_off, R.mipmap.menu_home_category_off,
                R.mipmap.menu_home_find_off, R.mipmap.menu_home_mine_off};
        mIconSelectIds = new int[]{
                R.mipmap.menu_home_first_on, R.mipmap.menu_home_category_on,
                R.mipmap.menu_home_find_on, R.mipmap.menu_home_mine_on};

        for (int i = 0; i < mTitles.length; i++) { //设置tab的标题、选中图标、未选中图标
            mTabEntities.add(new MainTabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        mTabLayout.setTabData(mTabEntities, this, R.id.flayout_main, mFragments); //给tab设置数据和关联的fragment
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mTabLayout = (CommonTabLayout) findViewById(R.id.tabLayout_main);
        ivSearch = (ImageView) findViewById(R.id.search_image_main);
        ivMore = (ImageView) findViewById(R.id.image_more_main);
        tvTitle = (TextView) findViewById(R.id.text_title_main);
        ivTitle = (ImageView) findViewById(R.id.image_title_main);
        ivCart = (ImageView) findViewById(R.id.image_cart);

        popupWindow = new PopupWindow();
        View contentView = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.more_popwindow, null);
        popupWindow.setContentView(contentView);

        weChatLayout = (LinearLayout) contentView.findViewById(R.id.layout_weChat);
        inviteLayout = (LinearLayout) contentView.findViewById(R.id.layout_invite);
        feedbackLayout = (LinearLayout) contentView.findViewById(R.id.layout_feedback);
        settingLayout = (LinearLayout) contentView.findViewById(R.id.layout_setting);
    }

    /**
     * 设置监听
     */
    private void setListener() {
        ivSearch.setOnClickListener(new OnClickListener() {       //搜索的监听
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        ivMore.setOnClickListener(new OnClickListener() {     //popWindow的监听
            @Override
            public void onClick(View v) {
                if (isShow) {
                    isShow = false;
                    popupWindow.setWidth(LayoutParams.WRAP_CONTENT);
                    popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
                    popupWindow.showAsDropDown(ivMore);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setOutsideTouchable(true);
                } else {
                    isShow = true;
                    popupWindow.dismiss();
                }
            }
        });

        ivCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这里要实现购物车Activity", Toast.LENGTH_SHORT).show();
            }
        });

        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switch (position) {
                    case 0:
                        ivCart.setVisibility(View.VISIBLE);
                        ivSearch.setVisibility(View.VISIBLE);
                        ivMore.setVisibility(View.VISIBLE);
                        ivTitle.setVisibility(View.VISIBLE);
                        tvTitle.setVisibility(View.GONE);
                        break;
                    case 1:
                        ivCart.setVisibility(View.INVISIBLE);
                        ivSearch.setVisibility(View.VISIBLE);
                        ivMore.setVisibility(View.INVISIBLE);
                        ivTitle.setVisibility(View.INVISIBLE);
                        tvTitle.setVisibility(View.VISIBLE);
                        tvTitle.setText("分类");
                        break;
                    case 2:
                        ivCart.setVisibility(View.INVISIBLE);
                        ivSearch.setVisibility(View.INVISIBLE);
                        ivMore.setVisibility(View.INVISIBLE);
                        ivTitle.setVisibility(View.INVISIBLE);
                        tvTitle.setVisibility(View.VISIBLE);
                        tvTitle.setText("发现");
                        break;
                    case 3:
                        ivCart.setVisibility(View.INVISIBLE);
                        ivSearch.setVisibility(View.INVISIBLE);
                        ivMore.setVisibility(View.INVISIBLE);
                        ivTitle.setVisibility(View.INVISIBLE);
                        tvTitle.setVisibility(View.VISIBLE);
                        tvTitle.setText("我");
                        break;
                }
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        weChatLayout.setOnClickListener(new OnClickListener() { //微信的监听
            @Override
            public void onClick(View v) {
                weChatLayout.setBackgroundColor(getResources().getColor(R.color.gray));
                inviteLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                feedbackLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                settingLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                startActivity(new Intent(MainActivity.this,
                        WeChatActivity.class));
                popupWindow.dismiss();
            }
        });
        inviteLayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                weChatLayout.setBackgroundColor(getResources().getColor(R.color.white));
                inviteLayout.setBackgroundColor(getResources().getColor(
                        R.color.gray));
                feedbackLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                settingLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                startActivity(new Intent(MainActivity.this,
                        InviteActivity.class));
                popupWindow.dismiss();
            }
        });
        feedbackLayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                weChatLayout.setBackgroundColor(getResources().getColor(R.color.white));
                inviteLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                feedbackLayout.setBackgroundColor(getResources().getColor(
                        R.color.gray));
                settingLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                startActivity(new Intent(MainActivity.this,
                        FeedbackActivity.class));
                popupWindow.dismiss();
            }
        });
        settingLayout.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                weChatLayout.setBackgroundColor(getResources().getColor(R.color.white));
                inviteLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                feedbackLayout.setBackgroundColor(getResources().getColor(
                        R.color.white));
                settingLayout.setBackgroundColor(getResources().getColor(
                        R.color.gray));
                startActivity(new Intent(MainActivity.this,
                        SettingActivity.class));
                popupWindow.dismiss();
            }
        });


    }


    private long duration_time; //间隔时间

    /**
     * 退出程序
     */
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - duration_time <= 2000) {
            super.onBackPressed();
        }
        duration_time = System.currentTimeMillis();
        Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
    }
}
