package com.example.constellation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/*
 * 项目名： constellation
 * 包名： com.example.constellation.adapter
 * 文件名： GuideAdapter
 * 创建者：hanhehuann
 * 创建时间：2020-05-29 10:00
 * 描述：TODO
 */

public class GuideAdapter extends PagerAdapter {

    //Context context;
    List<ImageView> mDatas;

    public GuideAdapter(List<ImageView> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = mDatas.get(position);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView imageView = mDatas.get(position);
        container.removeView(imageView);

    }
}
