package com.example.constellation.adapter;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.adapter
 * 文件名： AnalysisBeanAdapter
 * 创建者：hanhehuann
 * 创建时间：2020-05-27 14:19
 * 描述：TODO
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.StarAnalysisBean;

import java.util.List;

public class AnalysisBeanAdapter extends BaseAdapter {

    Context context;
    List<StarAnalysisBean> mDatas;

    public AnalysisBeanAdapter(Context context, List<StarAnalysisBean> mDatas) {
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
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_star_analysis,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        StarAnalysisBean bean = mDatas.get(i);
        viewHolder.titleTv.setText(bean.getTitle());
        viewHolder.contentTv.setText(bean.getContent());
        viewHolder.contentTv.setBackgroundResource(bean.getColor());
        return view;
    }

    class ViewHolder{
        TextView titleTv,contentTv;
        public ViewHolder(View view){
            titleTv = view.findViewById(R.id.itemstar_tv_title);
            contentTv = view.findViewById(R.id.itemstar_tv_content);
        }
    }
}
