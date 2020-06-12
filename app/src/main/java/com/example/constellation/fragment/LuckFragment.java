package com.example.constellation.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.constellation.LuckAnalysisActivity;
import com.example.constellation.R;
import com.example.constellation.adapter.LuckBaseAdapter;
import com.example.constellation.bean.StarInfoBean;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public class LuckFragment extends Fragment {

    private GridView luckGv;
    List<StarInfoBean.StarinfoBean> mDatas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_luck, container, false);
        luckGv = view.findViewById(R.id.luckfrag_gv);
        //获取数据源
        Bundle bundle = getArguments();
        StarInfoBean info = (StarInfoBean) bundle.getSerializable("info");
        mDatas = info.getStarinfo();
        //创建适配器对象
        LuckBaseAdapter luckBaseAdapter = new LuckBaseAdapter(getContext(), mDatas);
        //设置适配器
        luckGv.setAdapter(luckBaseAdapter);

        luckGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StarInfoBean.StarinfoBean starinfoBean = mDatas.get(i);
                String name = starinfoBean.getName();
                Intent intent = new Intent(getContext(), LuckAnalysisActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        return view;
    }

}
