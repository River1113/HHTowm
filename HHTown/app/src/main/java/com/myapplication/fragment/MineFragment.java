package com.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.myapplication.R;
import com.myapplication.activity.FeedbackActivity;
import com.myapplication.activity.JDActivity;
import com.myapplication.activity.LoginActivity;
import com.myapplication.activity.MyLikeActivity;
import com.myapplication.activity.RecommendActivity;
import com.myapplication.activity.RegisterActivity;
import com.myapplication.activity.SettingActivity;
import com.myapplication.activity.TBActivity;
import com.myapplication.adapter.MyListViewAdapter;

/**
 * 我的
 */
public class MineFragment extends Fragment {
    private ImageView userIcon;
    private ListView listViewMine;
    private Button loginBtn, registerBtn;
    private int[] images;
    private String[] titles;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        iniData();
        setListener();
    }

    private void setMyAdapter() {

    }

    private void setListener() {
        //登录监听
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        //注册监听
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });

        listViewMine.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:     //我喜欢的
                        startActivity(new Intent(getActivity(), MyLikeActivity.class));
                        break;

                    case 1:     //淘宝订单
                        startActivity(new Intent(getActivity(), TBActivity.class));
                        break;

                    case 2:     //京东订单
                        startActivity(new Intent(getActivity(), JDActivity.class));
                        break;
                    case 3:     //应用推荐
                        startActivity(new Intent(getActivity(), RecommendActivity.class));
                        break;

                    case 4:     //意见反馈
                        startActivity(new Intent(getActivity(), FeedbackActivity.class));
                        break;

                    case 5:     //设置
                        Intent intent = new Intent(getActivity(), SettingActivity.class);
                        //intent.putExtra("isLogin", isLogin);
                        startActivityForResult(intent, 1);

                        break;
                }
            }

        });

        listViewMine.setAdapter(new MyListViewAdapter(getActivity(), images, titles));
    }

    private void iniData() {
        images = new int[]{R.mipmap.mylike_icon, R.mipmap.tb_icon, R.mipmap.jd_icon,
                R.mipmap.feedback_icon, R.mipmap.download_icon, R.mipmap.seting_icon};
        titles = new String[]{"我喜欢的", "淘宝订单", "京东订单", "应用推荐",
                "意见反馈", "设置"};
    }

    private void initView(View view) {
        userIcon = (ImageView) view.findViewById(R.id.icon_user);
        listViewMine = (ListView) view.findViewById(R.id.listView_mine);
        loginBtn = (Button) view.findViewById(R.id.btn_login);
        registerBtn = (Button) view.findViewById(R.id.btn_register);
    }


}
