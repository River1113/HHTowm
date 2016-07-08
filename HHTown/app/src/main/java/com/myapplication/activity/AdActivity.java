package com.myapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.myapplication.R;
import com.myapplication.app.MyApp;

/**
 * 广告页面
 */
public class AdActivity extends AppCompatActivity {
    private ImageView ivAd;

    private static final int MSG_SPLASH = 0x00;
    private static final int DURATION_SPLASH = 1000;

    private int count = 3;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_SPLASH) {
                count--;
                if (count <= 0) {   //倒计时结束判断
                    if (handler.hasMessages(MSG_SPLASH)) {
                        handler.removeMessages(MSG_SPLASH); //结束时移除消息
                    }
                    toWhichActivity();
                } else {
                    handler.sendEmptyMessageDelayed(MSG_SPLASH, DURATION_SPLASH);
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ivAd = (ImageView) findViewById(R.id.iv_advertisement);
        ivAd.setImageResource(R.mipmap.splash); //设置splash界面图片
        handler.sendEmptyMessageAtTime(MSG_SPLASH, DURATION_SPLASH);
    }

    /**
     * 跳转界面
     */
    private void toWhichActivity() {
        Intent intent = new Intent();
        if (MyApp.isFirstLogin()) {   //判断是否第一次登陆
            Intent intent1 = intent.setClass(AdActivity.this, GuideActivity.class);
        } else {
            intent.setClass(AdActivity.this, MainActivity.class);
            //intent.setClass(AdActivity.this, GuideActivity.class);
        }
        startActivity(intent);
        finish();
    }

    /**
     * btnCountDownClick 点击倒计时的监听
     *
     * @param view
     */
    public void btnCountDownClick(View view) {
        if (handler.hasMessages(MSG_SPLASH)) {  //直接移除消息,跳转界面
            handler.removeMessages(MSG_SPLASH);
        }
        toWhichActivity();
    }

}
