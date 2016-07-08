package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Bean.HomeMiddleCategoryBean;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/1.
 */
public class HomeMiddleCategoryAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<HomeMiddleCategoryBean> mData;

    public HomeMiddleCategoryAdapter(List<HomeMiddleCategoryBean> middleCategoryBeanList, Context context) {
        mData = middleCategoryBeanList;
        mContext = context;
        mInflater = LayoutInflater.from(context);
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
        ViewHolder mHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_gridview_middlecategory, null);
            mHolder = new ViewHolder();
            mHolder.initView(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
            HomeMiddleCategoryBean bean = mData.get(position);
            Picasso.with(mContext)
                    .load(bean.getIcon()).placeholder(R.mipmap.phote_border).into(mHolder.icon);
            mHolder.title.setText(bean.getName());
            mHolder.desc.setText(bean.getDesc());

        return convertView;
    }

    class ViewHolder {
        private ImageView icon;
        private TextView title;
        private TextView desc;

        void initView(View view) {
            icon = (ImageView) view.findViewById(R.id.icon_middleCategory_item);
            title = (TextView) view.findViewById(R.id.title_middleCategory_item);
            desc = (TextView) view.findViewById(R.id.desc_middleCategory_item);
        }
    }
}
