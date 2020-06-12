package com.example.constellation.adapter;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.adapter
 * 文件名： StarBaseAdapter
 * 创建者：hanhehuann
 * 创建时间：2020-05-26 15:47
 * 描述：TODO
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.StarInfoBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarBaseAdapter extends BaseAdapter {
    private Context context;
    private List<StarInfoBean.StarinfoBean> mDatas;
    private Map<String, Bitmap> logoImgMap;

    public StarBaseAdapter(Context context, List<StarInfoBean.StarinfoBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        this.logoImgMap = AssetsUtils.getLogoImgMap();
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
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_star_gv,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();

        }
        //获取指定位置的数据
        StarInfoBean.StarinfoBean bean = mDatas.get(i);
        viewHolder.tv.setText(bean.getName());
        //获得图片
        Bitmap bitmap = logoImgMap.get(bean.getLogoname());
        viewHolder.cv.setImageBitmap(bitmap);
        return view;
    }
    //对item当中的控件进行声明和初始化操作
    class ViewHolder{
        CircleImageView cv;
        TextView tv;
        public ViewHolder(View view){
            cv = view.findViewById(R.id.item_star_iv);
            tv = view.findViewById(R.id.item_star_tv);

        }
    }
}
