package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.myapplication.Bean.FindListBean;
import com.myapplication.R;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class FindListViewAdapter extends BaseAdapter {

    private List<FindListBean> mData;
    private Context context;
    private LayoutInflater inflater;

    public FindListViewAdapter(Context context, List<FindListBean> findListBeen) {
        this.context = context;
        this.mData = findListBeen;
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
            convertView = inflater.inflate(R.layout.item_listview_find, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.initView(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        FindListBean bean = mData.get(position);

        viewHolder.title.setText(bean.getTitle());
        viewHolder.gridView.setAdapter(new FindGridViewAdapter(context, bean.getFindGridBeanList()));

        return convertView;
    }

    class ViewHolder {
        private TextView title;
        private GridView gridView;

        void initView(View view) {
            title = (TextView) view.findViewById(R.id.text_list_item_find);
            gridView = (GridView) view.findViewById(R.id.grid_list_item_find);
        }
    }
}
