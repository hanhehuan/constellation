package com.example.constellation.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.LuckItemBean;

import java.util.List;

/*
 * 项目名： constellation
 * 包名： com.example.constellation.adapter
 * 文件名： LuckAnalysisAdapter
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 17:09
 * 描述：TODO
 */

public class LuckAnalysisAdapter extends BaseAdapter {

    Context context;
    List<LuckItemBean> mDatas;

    public LuckAnalysisAdapter(Context context, List<LuckItemBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_luck_lv,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        LuckItemBean itemBean = mDatas.get(i);
        viewHolder.titleTv.setText(itemBean.getTitle());
        viewHolder.contentTv.setText(itemBean.getContent());
        GradientDrawable drawable = (GradientDrawable) viewHolder.titleTv.getBackground();
        drawable.setColor(itemBean.getColor());
        return view;
    }
    class ViewHolder{
        TextView titleTv,contentTv;
        public ViewHolder(View view){
            titleTv = view.findViewById(R.id.item_luck_tv_title);
            contentTv = view.findViewById(R.id.item_luck_tv_content);
        }
    }
}
