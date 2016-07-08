package com.myapplication.app;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * MyApp
 *
 * @author River
 * @date 2016/6/27.
 */
public class MyApp extends Application {
    public static int screenWidth;
    public static int screenHeight;

    private RequestQueue requestQueue;
    private static Context mContext;
    public static MyApp instance;

    public static MyApp newInstance() {
        return instance;
    }

    private static final String SHREF_FILENAME = "config";
    public static final String IS_FIRST_LOGIN = "isFirstLogin";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        instance = this;
        screenWidth = mContext.getResources().getDisplayMetrics().widthPixels;
        screenHeight = mContext.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 创建请求队列
     *
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(this);
        }
        return requestQueue;
    }

    /**
     * 判断是否第一次登录
     */
    public static boolean isFirstLogin() {
        SharedPreferences shref = mContext.getSharedPreferences(SHREF_FILENAME, Context.MODE_PRIVATE);
        boolean isFirst = shref.getBoolean(IS_FIRST_LOGIN, true);
        if (isFirst) {
            shref.edit().putBoolean(IS_FIRST_LOGIN, false).apply();
        }
        return isFirst;
    }
}
