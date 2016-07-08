package com.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.myapplication.activity.BannerActivity;
import com.myapplication.Bean.HomeBannerBean;
import com.myapplication.Bean.HomeCategoryBean;
import com.myapplication.Bean.HomeMiddleCategoryBean;
import com.myapplication.Bean.HomeShareListBean;
import com.myapplication.Bean.HomeStrategiesBean;
import com.myapplication.R;
import com.myapplication.activity.CategoryActivity;
import com.myapplication.activity.MainActivity;
import com.myapplication.activity.TopicActivity;
import com.myapplication.adapter.HomeBannerAdapter;
import com.myapplication.adapter.CategoryAdapter;
import com.myapplication.adapter.HomeMiddleCategoryAdapter;
import com.myapplication.adapter.HomeShareRVAdapter;
import com.myapplication.adapter.HomeStrategiesAdapter;
import com.myapplication.app.MyApp;
import com.myapplication.utils.UrlUtils;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        initData();

        handler.sendEmptyMessageDelayed(MSG_TURN, DURATION_TURN);
        bannerViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int state) { //滑动状态的判断
                // TODO Auto-generated method stub
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        //停止滑动状态
                        if (!handler.hasMessages(MSG_TURN)) { //如果没有轮询
                            //重新开始轮询
                            handler.sendEmptyMessageDelayed(MSG_TURN, DURATION_TURN);
                        }
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        //手指在屏幕滑动的状态
                        //发送停止轮询的消息(立即发送)
                        handler.sendEmptyMessage(MSG_TURN_STOP);
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:

                        break;
                    default:
                        break;
                }
            }
        });

    }

    private ViewPager bannerViewPager;
    private CirclePageIndicator indicator;
    private GridView categoryGridView, middleCategoryGridView;
    private ListView strategiesListView;
    private RecyclerView shareListRecyclerView;

    private List<ImageView> imageList;
    private List<HomeBannerBean> bannerBeanList;
    private List<HomeCategoryBean> categoryBeanList;
    private List<HomeMiddleCategoryBean> middleCategoryBeanList;
    private List<HomeStrategiesBean> strategiesBeanList;
    private List<HomeShareListBean> shareListBeanList;

    public static final int MSG_TURN = 0x11;
    public static final int MSG_TURN_STOP = 0x12;
    public static final long DURATION_TURN = 2000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_TURN: //开始轮询消息
                    //Log.d(TAG, "111 " + pointLinearLayout);
                    //Log.d(TAG, "111 " + pointLinearLayout.getChildAt(pointIndex));
                    int pager = bannerViewPager.getCurrentItem();
                    pager++;
                    bannerViewPager.setCurrentItem(pager);
                    handler.sendEmptyMessageDelayed(MSG_TURN, DURATION_TURN);
                    break;
                case MSG_TURN_STOP: //停止轮询消息
                    handler.removeMessages(MSG_TURN); //移除轮询的消息
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 初始化View
     *
     * @param view
     */
    private void initView(View view) {
        bannerViewPager = (ViewPager) view.findViewById(R.id.viewPager_bannerList_home);
        indicator = (CirclePageIndicator) view.findViewById(R.id.indicator_bannerList);
        categoryGridView = (GridView) view.findViewById(R.id.gridView_categoryList_home);
        middleCategoryGridView = (GridView) view.findViewById(R.id.gridView_middleCategoryList_home);
        strategiesListView = (ListView) view.findViewById(R.id.listView_strategies_home);
        shareListRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_shareList_home);
        shareListRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    /**
     * 数据源
     */
    private void initData() {
        imageList = new ArrayList<>();
        bannerBeanList = new ArrayList<>();
        categoryBeanList = new ArrayList<>();
        middleCategoryBeanList = new ArrayList<>();
        strategiesBeanList = new ArrayList<>();
        shareListBeanList = new ArrayList<>();
        getJsonData(UrlUtils.HOME_FRAGMENT_UTILS);
    }

    /**
     * 设置监听
     */
    private void setListener() {
        for (int i = 0; i < imageList.size(); i++) {
            final int location = i;
            imageList.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), BannerActivity.class);
                    HomeBannerBean homeBannerBean = bannerBeanList.get(location);
                    intent.putExtra("name", homeBannerBean.getName());
                    intent.putExtra("url", homeBannerBean.getUrl());
                    startActivity(intent);
                }
            });
        }

        categoryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeCategoryBean homeCategoryBean = categoryBeanList.get(position);
                String name = homeCategoryBean.getName();
                Intent intent = new Intent(getActivity(), CategoryActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        middleCategoryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        MainActivity.mTabLayout.setCurrentTab(2);
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
            }
        });

        strategiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), TopicActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getJsonData(String url) {
        RequestQueue requestQueue = MyApp.newInstance().getRequestQueue();
        JSONObject jsonObject = new JSONObject();
        JsonObjectRequest request = new JsonObjectRequest(url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "onResponse: " + response);
                        //获取数据
                        downLoadData(response);

                        bannerViewPager.setAdapter(new HomeBannerAdapter(imageList));

                        categoryGridView.setAdapter(new CategoryAdapter(categoryBeanList, getActivity()));

                        middleCategoryGridView.setAdapter(new HomeMiddleCategoryAdapter(middleCategoryBeanList, getActivity()));

                        strategiesListView.setAdapter(new HomeStrategiesAdapter(strategiesBeanList, getActivity()));

                        shareListRecyclerView.setAdapter(new HomeShareRVAdapter(getActivity(), shareListBeanList));

                        setListener();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse: " + error);
                    }
                });
        requestQueue.add(request);
    }

    private void downLoadData(JSONObject response) {
        try {
            //获取bannerList的数据
            JSONArray bannerList = response.getJSONArray("bannerList");
            for (int i = 0; i < bannerList.length(); i++) {
                JSONObject o = bannerList.getJSONObject(i);
                HomeBannerBean bean = new HomeBannerBean(o.optString("logo"), o.optString("logo2"), o.optString("type"),
                        o.optString("name"), o.optString("desc"), o.optString("id"), o.optString("url"));
                bannerBeanList.add(bean);
                Log.i(TAG, bean.toString());
            }
            for (int i = 0; i < bannerBeanList.size(); i++) {
                ImageView iv = new ImageView(getActivity());
                iv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Picasso.with(getActivity()).load(bannerBeanList.get(i).getLogo2()).into(iv);
                imageList.add(iv);
            }

            Log.i(TAG, "imageList: " + imageList.size());
            //获取categoryList的数
            JSONArray categoryList = response.getJSONArray("categoryList");
            for (int i = 0; i < categoryList.length(); i++) {
                JSONObject o = categoryList.getJSONObject(i);
                HomeCategoryBean bean = new HomeCategoryBean(o.getString("icon"), o.getString("name"));
                categoryBeanList.add(bean);
            }

            //获取middleCategoryList的数据
            JSONArray middleCategoryList = response.getJSONArray("middleCategoryList");
            for (int i = 0; i < middleCategoryList.length(); i++) {
                JSONObject o = middleCategoryList.getJSONObject(i);
                HomeMiddleCategoryBean bean = new HomeMiddleCategoryBean(o.getString("icon"), o.getString("name"), o.getString("desc"));
                middleCategoryBeanList.add(bean);
            }


            //获取strategies_at_index的数据,设置适配器
            JSONArray strategies = response.getJSONArray("strategies_at_index");
            for (int i = 0; i < strategies.length(); i++) {
                JSONObject o = strategies.getJSONObject(i);
                HomeStrategiesBean bean = new HomeStrategiesBean(o.getString("share_id"), o.getString("name"), o.getString("best_desc"), o.getString("icon"));
                strategiesBeanList.add(bean);
            }


            //获取shareList的数据,设置适配器
            JSONArray shareList = response.getJSONArray("shareList");
            for (int i = 0; i < shareList.length(); i++) {
                JSONObject o = shareList.getJSONObject(i);
                HomeShareListBean bean = new HomeShareListBean(o.getString("share_id"), o.getString("desc"), o.getInt("is_strategy"),
                        o.getString("name"), o.getString("price"), o.getString("original_price"), o.getInt("is_free_shipping"),
                        o.getString("like"), o.getInt("low"),
                        o.getString("url"), o.getString("goods_url"), o.getString("source"), o.getString("baike_url"),
                        o.getString("best_desc"), o.getString("external_id"), o.getString("source_title"),
                        o.getString("detail_logo"), o.getString("icon"));
                shareListBeanList.add(bean);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.i(TAG, "JSONException: " + e);
        }
    }
}
