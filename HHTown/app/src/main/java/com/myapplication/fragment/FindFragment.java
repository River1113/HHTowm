package com.myapplication.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.myapplication.Bean.FindGridBean;
import com.myapplication.Bean.FindListBean;
import com.myapplication.R;
import com.myapplication.adapter.FindListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 发现
 */
public class FindFragment extends Fragment {
    private ListView listViewFind;
    private List<FindListBean> findListBeanList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        setListener();
    }

    private void initView(View view) {
        listViewFind = (ListView) view.findViewById(R.id.listView_find);
    }

    private void initData() {
        Resources res = getResources();
        List<List<FindGridBean>> mList = new ArrayList<>();
        List<FindGridBean> list1 = new ArrayList<>();
        List<FindGridBean> list2 = new ArrayList<>();
        ;
        List<FindGridBean> list3 = new ArrayList<>();
        List<FindGridBean> list4 = new ArrayList<>();
        List<FindGridBean> list5 = new ArrayList<>();

        String[] imageUrls_1 = res.getStringArray(R.array.imageUrls_1);
        String[] imageNames_1 = res.getStringArray(R.array.imageNames_1);

        String[] imageUrls_2 = res.getStringArray(R.array.imageUrls_2);
        String[] imageNames_2 = res.getStringArray(R.array.imageNames_2);

        String[] imageUrls_3 = res.getStringArray(R.array.imageUrls_3);
        String[] imageNames_3 = res.getStringArray(R.array.imageNames_3);

        String[] imageUrls_4 = res.getStringArray(R.array.imageUrls_4);
        String[] imageNames_4 = res.getStringArray(R.array.imageNames_4);

        String[] imageUrls_5 = res.getStringArray(R.array.imageUrls_5);
        String[] imageNames_5 = res.getStringArray(R.array.imageNames_5);

        //"功用"
        for (int i = 0; i < imageNames_1.length; i++) {
            FindGridBean findGridBean = new FindGridBean(imageUrls_1[i], imageNames_1[i]);
            list1.add(findGridBean);
        }

        //"口感"
        for (int i = 0; i < imageNames_2.length; i++) {
            FindGridBean findGridBean = new FindGridBean(imageUrls_2[i], imageNames_2[i]);
            list2.add(findGridBean);
        }
        //"节日"
        for (int i = 0; i < imageNames_3.length; i++) {
            FindGridBean findGridBean = new FindGridBean(imageUrls_3[i], imageNames_3[i]);
            list3.add(findGridBean);
        }
        //"场合"
        for (int i = 0; i < imageNames_4.length; i++) {
            FindGridBean findGridBean = new FindGridBean(imageUrls_4[i], imageNames_4[i]);
            list4.add(findGridBean);
        }
        //"人群"
        for (int i = 0; i < imageNames_5.length; i++) {
            FindGridBean findGridBean = new FindGridBean(imageUrls_5[i], imageNames_5[i]);
            list5.add(findGridBean);
        }
        mList.add(list1);
        mList.add(list2);
        mList.add(list3);
        mList.add(list4);
        mList.add(list5);
        String[] titles = getResources().getStringArray(R.array.titles);

        for (int i = 0; i < titles.length; i++) {
            FindListBean findListBean = new FindListBean(titles[i], mList.get(i));
            findListBeanList.add(findListBean);
        }


    }

    private void setListener() {
        listViewFind.setAdapter(new FindListViewAdapter(getActivity(), findListBeanList));
    }


}
