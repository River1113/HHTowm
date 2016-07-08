package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.myapplication.Bean.FindGridBean;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class FindGridViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<FindGridBean> mData;

    public FindGridViewAdapter(Context context, List<FindGridBean> findGridBeanList) {
        this.context = context;
        this.mData = findGridBeanList;
        inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.item_gridview_find, null);
            viewHolder = new ViewHolder();
            viewHolder.initView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        FindGridBean bean = mData.get(position);
        Picasso.with(context).load(bean.getImgUrl()).placeholder(R.mipmap.phote_border)
                .into(viewHolder.icon);
        viewHolder.name.setText(bean.getImgName());

        return convertView;
    }

    class ViewHolder {
        private ImageView icon;
        private TextView name;

        void initView(View view) {
            icon = (ImageView) view.findViewById(R.id.image_grid_item_find);
            name = (TextView) view.findViewById(R.id.text_grid_item_find);
        }
    }
}
