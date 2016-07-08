package com.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.myapplication.Bean.SortCatListBean;
import com.myapplication.Bean.SortSubListBean;
import com.myapplication.R;
import com.myapplication.adapter.SortGridViewAdapter;
import com.myapplication.utils.UrlUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类
 */
public class SortFragment extends Fragment {
    public static final String TAG = "SortFragment";
    public static final int CATLIST_TAG = 3;
    private HttpUtils httpUtils;

    private RadioGroup radioGroup;
    private GridView gridView;

    public List<SortSubListBean> subList0 = new ArrayList<>();
    public List<SortSubListBean> subList1 = new ArrayList<>();
    public List<SortSubListBean> subList2 = new ArrayList<>();
    public List<SortSubListBean> subTags = new ArrayList<>();
    public List<SortSubListBean> subList4 = new ArrayList<>();
    public List<SortSubListBean> subList5 = new ArrayList<>();
    public List<SortSubListBean> subList6 = new ArrayList<>();
    public List<SortSubListBean> subList7 = new ArrayList<>();
    public List<SortSubListBean> subList8 = new ArrayList<>();

    public List<SortCatListBean> catList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sort, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

        iniData();

        setListener();
    }

    private void initView(View view) {
        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup_sort);
        gridView = (GridView) view.findViewById(R.id.gridView_sort);
    }

    private void iniData() {

    }


    private SortGridViewAdapter adapter;

    private void setListener() {
        getJsonData();
        adapter = new SortGridViewAdapter(getActivity());
        adapter.setSubList(subList0);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, final int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton0:
                        adapter.setSubList(subList0);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton1:
                        adapter.setSubList(subList2);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton2:
                        adapter.setSubList(subList1);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton3:
                        adapter.setSubList(subTags);
                        gridView.setNumColumns(3);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton4:
                        adapter.setSubList(subList4);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton5:
                        adapter.setSubList(subList5);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton6:
                        adapter.setSubList(subList6);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton7:
                        adapter.setSubList(subList7);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    case R.id.radioButton8:
                        adapter.setSubList(subList8);
                        gridView.setNumColumns(2);
                        gridView.setAdapter(adapter);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void getJsonData() {
        httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, UrlUtils.SORT_FRAGMENT_UTILS, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                Log.i(TAG, "onSuccess: " + responseInfo);
                String json = responseInfo.result;
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray catListArray = jsonObject.getJSONArray("catList");
                    for (int i = 0; i < catListArray.length(); i++) {
                        JSONObject obj = catListArray.getJSONObject(i);
                        int cat_id = obj.getInt("cat_id");
                        String name = obj.getString("name");
                        String logo = obj.getString("logo");
                        int parent_id = obj.getInt("parent_id");
                        int is_list = obj.getInt("is_list");
                        if (i == 3) {   //subTags的情况
                            JSONArray sub_Tags = obj.getJSONArray("subTags");
                            for (int k = 0; k < sub_Tags.length(); k++) {
                                JSONObject o = sub_Tags.getJSONObject(k);
                                int child_id = o.getInt("cat_id");
                                String child_name = o.getString("name");
                                String child_logo = o.getString("logo");
                                subTags.add(new SortSubListBean(child_id, child_name, child_logo));
                            }
                        } else {    //其他的情况
                            JSONArray sub_List = obj.getJSONArray("subList");
                            for (int j = 0; j < sub_List.length(); j++) {
                                JSONObject o = sub_List.getJSONObject(j);
                                int child_id = o.getInt("cat_id");
                                String child_name = o.getString("name");
                                String child_logo = o.getString("logo");
                                if (i == 0) {
                                    subList0.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 1) {
                                    subList1.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 2) {
                                    subList2.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 4) {
                                    subList4.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 5) {
                                    subList5.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 6) {
                                    subList6.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 7) {
                                    subList7.add(new SortSubListBean(child_id, child_name, child_logo));
                                } else if (i == 8) {
                                    subList8.add(new SortSubListBean(child_id, child_name, child_logo));
                                }
                            }
                        }
                        catList.add(new SortCatListBean(cat_id, name, logo, parent_id, is_list));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                Log.i(TAG, "onFailure: " + error);
            }
        });
    }


}
