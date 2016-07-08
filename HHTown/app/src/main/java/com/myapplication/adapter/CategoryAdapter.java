package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Bean.HomeCategoryBean;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/6/30.
 */
public class CategoryAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<HomeCategoryBean> mData;

    public CategoryAdapter(List<HomeCategoryBean> categoryBeanList, Context context) {
        mData = categoryBeanList;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_gridview_category, null);
            viewHolder = new ViewHolder();
            viewHolder.initView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HomeCategoryBean bean = mData.get(position);
        Picasso.with(mContext)
                .load(bean.getIcon())
                .placeholder(R.mipmap.phote_border).into(viewHolder.icon);
        viewHolder.iconName.setText(bean.getName());

        return convertView;
    }

    class ViewHolder {
        private ImageView icon;
        private TextView iconName;

        void initView(View view) {
            icon = (ImageView) view.findViewById(R.id.image_category_item);
            iconName = (TextView) view.findViewById(R.id.text_category_item);
        }
    }
}
