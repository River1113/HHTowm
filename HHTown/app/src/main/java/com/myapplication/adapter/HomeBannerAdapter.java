package com.myapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/6/29.
 */
public class HomeBannerAdapter extends PagerAdapter {
    private List<ImageView> imageViews;

    public HomeBannerAdapter(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;//无线循环
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 视图对象动态绘制
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //对ViewPager页号求模取出View列表中要显示的项
        position %= imageViews.size();
        if (position < 0) {
            position = imageViews.size() + position;
        }
        ImageView view = imageViews.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent vp = view.getParent();
        if (vp != null) {
            ViewGroup parent = (ViewGroup) vp;
            parent.removeView(view);
        }
        container.addView(view);
        //add listeners here if necessary
        return view;

    }

    /**
     * 视图对象动态删除
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
//        int index = position % imageViews.size();
//        View v = imageViews.get(index);
//        container.removeView(v);
//        ((ViewPager) container).removeView(v);
    }

}
