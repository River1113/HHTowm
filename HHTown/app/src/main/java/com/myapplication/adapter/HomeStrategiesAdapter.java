package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Bean.HomeStrategiesBean;
import com.myapplication.R;
import com.myapplication.utils.CornerImageTransFormation;
import com.myapplication.utils.CropCircleTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/1.
 */
public class HomeStrategiesAdapter extends BaseAdapter {
    public static final int IMAGE_RADIUS = 6;//图片的倒角
    private LayoutInflater mInflater;
    private Context mContext;
    private List<HomeStrategiesBean> mData;


    public HomeStrategiesAdapter(List<HomeStrategiesBean> strategiesBeanList, Context context) {
        mData = strategiesBeanList;
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
            convertView = mInflater.inflate(R.layout.item_gridview_strategies, null);
            viewHolder = new ViewHolder();
            viewHolder.initView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HomeStrategiesBean bean = mData.get(position);
        Picasso.with(mContext)
                .load(bean.getIcon()).transform(new CornerImageTransFormation(IMAGE_RADIUS))
                .placeholder(R.mipmap.bg_cache).into(viewHolder.icon);
        viewHolder.iconName.setText(bean.getName());

        return convertView;
    }

    class ViewHolder {
        private ImageView icon;
        private TextView iconName;

        void initView(View view) {
            icon = (ImageView) view.findViewById(R.id.icon_strategies);
            iconName = (TextView) view.findViewById(R.id.name_strategies);

        }
    }
}
