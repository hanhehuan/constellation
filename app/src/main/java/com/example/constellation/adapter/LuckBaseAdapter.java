package com.example.constellation.adapter;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.adapter
 * 文件名： LuckBaseAdapter
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 15:12
 * 描述：TODO
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.StarInfoBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class LuckBaseAdapter extends BaseAdapter {

    Context context;
    List<StarInfoBean.StarinfoBean> mDatas;
    private final Map<String, Bitmap> contentImgMap;

    public LuckBaseAdapter(Context context, List<StarInfoBean.StarinfoBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        contentImgMap = AssetsUtils.getContentImgMap();
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
            view = LayoutInflater.from(context).inflate(R.layout.item_luck_gv,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        StarInfoBean.StarinfoBean bean = mDatas.get(i);
        viewHolder.tv.setText(bean.getName());
        viewHolder.cv.setImageBitmap(contentImgMap.get(bean.getLogoname()));
        return view;
    }
    class ViewHolder{
        CircleImageView cv;
        TextView tv;
        public ViewHolder(View view){
            cv = view.findViewById(R.id.item_luck_iv);
            tv = view.findViewById(R.id.item_luck_tv);
        }
    }
}
