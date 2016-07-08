package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Bean.SortSubListBean;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class SortGridViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    public List<SortSubListBean> mData;

    public SortGridViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setSubList(List<SortSubListBean> subList) {
        this.mData = subList;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gridview_sort, null);
            viewHolder = new ViewHolder();
            viewHolder.initView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SortSubListBean bean = mData.get(position);
        viewHolder.sortName.setText(bean.getName());
        Picasso.with(context).load(bean.getLogo()).into(viewHolder.sortImg);
        return convertView;
    }

    class ViewHolder {
        ImageView sortImg;
        TextView sortName;

        void initView(View view) {
            sortImg = (ImageView) view.findViewById(R.id.image_item_sort);
            sortName = (TextView) view.findViewById(R.id.text_item_sort);
        }
    }
}
