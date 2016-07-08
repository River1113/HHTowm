package com.myapplication.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/6/28.
 */
public class GuideAdapter extends PagerAdapter {
    private List<ImageView> imageViews;

    public GuideAdapter(List<ImageView> imageViews){
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return imageViews == null? 0 : imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViews.get(position);
        container.addView(imageView);
        return imageView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
