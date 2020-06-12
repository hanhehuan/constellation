package com.example.constellation.adapter;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.adapter
 * 文件名： StarPagerAdapter
 * 创建者：hanhehuann
 * 创建时间：2020-05-26 16:29
 * 描述：TODO
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class StarPagerAdapter extends PagerAdapter {

    Context context;
    List<ImageView> imgList;

    public StarPagerAdapter(Context context, List<ImageView> imgList) {
        this.context = context;
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = imgList.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView imageView = imgList.get(position);
        container.removeView(imageView);
    }
}
