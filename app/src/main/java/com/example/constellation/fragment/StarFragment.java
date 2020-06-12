package com.example.constellation.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.constellation.R;
import com.example.constellation.StarAnalysisActivity;
import com.example.constellation.adapter.StarBaseAdapter;
import com.example.constellation.adapter.StarPagerAdapter;
import com.example.constellation.bean.StarInfoBean;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 星座fragment
 *  包括viewpager和gridview
 *
 */
public class StarFragment extends Fragment {

    private ViewPager starVP;
    private GridView starGV;
    LinearLayout pointLayout;
    private List<StarInfoBean.StarinfoBean> mDatas;
    private StarBaseAdapter starBaseAdapter;
    //声明图片数组
    int[] imgIds = {R.mipmap.pic_guanggao,R.mipmap.pic_star};
    //声明viewpage的数据源
    List<ImageView> ivLsit;
    //声明管理指示器小圆点的集合
    List<ImageView> pointList;
    private StarPagerAdapter starPagerAdapter;

    private static class MyHandler extends Handler{
        private final WeakReference<StarFragment> mFragment;
        private MyHandler(StarFragment fragment){
            this.mFragment = new WeakReference<StarFragment>(fragment);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            StarFragment fragment = mFragment.get();
            if(fragment != null){
                if(msg.what == 1){
                    //获取当前viewpage显示的页面
                    int item = fragment.starVP.getCurrentItem();
                    //判断是否是最后一张，如果是最后一张回到第一张，否则显示最后一张
                    if(item == fragment.ivLsit.size()-1){
                        fragment.starVP.setCurrentItem(0);
                    }else {
                        item++;
                        fragment.starVP.setCurrentItem(item);
                    }

                    //形成循环，接收消息的同时也要发送消息
                    fragment.handler.sendEmptyMessageDelayed(1,5000);
                }
            }
        }
    }

    MyHandler handler = new MyHandler(this);//创建handler

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_star, container, false);
        initView(view);
        Bundle bundle = getArguments();
        StarInfoBean infoBean = (StarInfoBean) bundle.getSerializable("info");
        mDatas = infoBean.getStarinfo();//获取关于星座的列表数据
        starBaseAdapter = new StarBaseAdapter(getContext(), mDatas);
        starGV.setAdapter(starBaseAdapter);
        initPager();
        setVPListener();
        setGVListener();
        handler.sendEmptyMessageDelayed(1,5000);
        return view;
    }
    /*GridView点击监听*/
    private void setGVListener() {
        starGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StarInfoBean.StarinfoBean bean = mDatas.get(i);
                Intent intent = new Intent(getContext(), StarAnalysisActivity.class);
                intent.putExtra("star",bean);
                startActivity(intent);
            }
        });
    }

    /*设置viewpager的监听器函数*/
    private void setVPListener() {
        starVP.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<pointList.size();i++){
                    pointList.get(i).setImageResource(R.mipmap.point_normal);
                }
                pointList.get(position).setImageResource(R.mipmap.point_focus);
            }
        });

    }

    /*设置viewpage显示的页面*/
    private void initPager() {
        ivLsit = new ArrayList<>();
        pointList = new ArrayList<>();
        for (int i=0;i<imgIds.length;i++){
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(imgIds[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //设置图片view的宽高
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(lp);
            //将图片view加载到集合中
            ivLsit.add(imageView);
            //创建图片对应的指示器小圆点
            ImageView piv = new ImageView(getContext());
            piv.setImageResource(R.mipmap.point_normal);
            LinearLayout.LayoutParams plp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            plp.setMargins(20,0,0,0);
            piv.setLayoutParams(plp);
            //将小圆点添加到布局当中
            pointLayout.addView(piv);
            //为了便于操作，将小圆点添加到统一管理的集合中
            pointList.add(piv);
        }
        //默认第一个小圆点获得焦点状态
        pointList.get(0).setImageResource(R.mipmap.point_focus);
        starPagerAdapter = new StarPagerAdapter(getContext(), ivLsit);
        starVP.setAdapter(starPagerAdapter);

    }

    private void initView(View view) {

        starVP = view.findViewById(R.id.starfrag_vp);
        starGV = view.findViewById(R.id.starfrag_gv);
        pointLayout = view.findViewById(R.id.starfrag_layout);




    }

}
