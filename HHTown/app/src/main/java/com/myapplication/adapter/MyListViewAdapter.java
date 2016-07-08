package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;

/**
 * @author Administrator
 * @date 2016/7/2.
 */
public class MyListViewAdapter extends BaseAdapter {

    private Context context;
    private int[] images;
    private String[] titles;

    public MyListViewAdapter(Context context, int[] images, String[] titles) {
        this.context = context;
        this.images = images;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_mine, null);
            viewHolder = new ViewHolder();
            viewHolder.initItemView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.icon.setImageResource(images[position]);
        viewHolder.title.setText(titles[position]);
        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView title;

        void initItemView(View v) {
            icon = (ImageView) v.findViewById(R.id.image_mine_item);
            title = (TextView) v.findViewById(R.id.text_mine_item);
        }
    }
}
