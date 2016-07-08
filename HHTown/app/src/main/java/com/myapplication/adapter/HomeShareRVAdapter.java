package com.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.Bean.HomeShareListBean;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/1.
 */
public class HomeShareRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEAD = 1;
    private static final int TYPE_ITEM = 2;

    private LayoutInflater inflater;
    private Context context;
    private List<HomeShareListBean> mData;

    public HomeShareRVAdapter(Context context, List<HomeShareListBean> shareListBeenList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mData = shareListBeenList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEAD) {
            View itemView = inflater.inflate(R.layout.item_recyclerview_header, parent, false);
            return new HeaderHolder(itemView);
        } else if (viewType == TYPE_ITEM) {
            View itemView = inflater.inflate(R.layout.item_recyclerview_sharelist, parent, false);
            return new ItemHolder(itemView);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEAD;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            HomeShareListBean bean = mData.get(position);
            headerHolder.time.setText(R.string.update_time);
            headerHolder.date.setText(R.string.date);
            Picasso.with(context).load(bean.getIcon()).into(headerHolder.goodsIcon);
            headerHolder.goodsName.setText(bean.getName());
            headerHolder.goodsPrice.setText(bean.getPrice());
            headerHolder.likeNum.setText(bean.getLike());
        } else {
            HomeShareListBean bean = mData.get(position);
            ItemHolder itemHolder = (ItemHolder) holder;
            Picasso.with(context).load(bean.getIcon()).into(itemHolder.goodsIcon);
            itemHolder.goodsName.setText(bean.getName());
            itemHolder.goodsPrice.setText(bean.getPrice());
            itemHolder.likeNum.setText(bean.getLike());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //第一条带时间的商品
    class HeaderHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private TextView date;
        private ImageView goodsIcon;
        private TextView goodsName;
        public TextView goodsPrice;
        public TextView likeNum;

        public HeaderHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.text_updateTime);
            date = (TextView) itemView.findViewById(R.id.text_date);
            goodsIcon = (ImageView) itemView.findViewById(R.id.icon_goods_shareListItem);
            goodsName = (TextView) itemView.findViewById(R.id.text_goodsName_shareListItem);
            goodsPrice = (TextView) itemView.findViewById(R.id.text_price_shareListItem);
            likeNum = (TextView) itemView.findViewById(R.id.text_like_shareListItem);
        }
    }

    //其他商品列表
    class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView goodsIcon;
        private TextView goodsName;
        public TextView goodsPrice;
        public TextView likeNum;

        public ItemHolder(View itemView) {
            super(itemView);
            goodsIcon = (ImageView) itemView.findViewById(R.id.icon_goods_shareListItem);
            goodsName = (TextView) itemView.findViewById(R.id.text_goodsName_shareListItem);
            goodsPrice = (TextView) itemView.findViewById(R.id.text_price_shareListItem);
            likeNum = (TextView) itemView.findViewById(R.id.text_like_shareListItem);
        }
    }
}
