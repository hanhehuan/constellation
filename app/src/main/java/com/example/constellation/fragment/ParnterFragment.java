package com.example.constellation.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.constellation.ParnterAnalysisActivity;
import com.example.constellation.R;
import com.example.constellation.bean.StarAnalysisBean;
import com.example.constellation.bean.StarInfoBean;
import com.example.constellation.utils.AssetsUtils;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParnterFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    ImageView manIv,womanIv;
    Spinner mansp,womansp;
    Button prizeBtn,analysisBtn;
    private List<StarInfoBean.StarinfoBean> starinfoBeanList;
    private List<String> nameList;
    private Map<String, Bitmap> contentImgMap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parnter, container, false);
        initView(view);
        /*获取activity传递的数据*/
        Bundle bundle = getArguments();
        StarInfoBean info = (StarInfoBean) bundle.getSerializable("info");
        starinfoBeanList = info.getStarinfo();
        nameList = new ArrayList<>();
        /*获取下拉适配器所需要的数据源*/
        for (int i=0;i<starinfoBeanList.size();i++){
            String name = starinfoBeanList.get(i).getName();
            nameList.add(name);
        }
        //创建适配器
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.item_parnter_sp, R.id.item_parnter_tv, nameList);
        //设置适配器
        mansp.setAdapter(arrayAdapter);
        womansp.setAdapter(arrayAdapter);
        //获取第一个图片资源
        String logoname = starinfoBeanList.get(0).getLogoname();
        contentImgMap = AssetsUtils.getContentImgMap();
        Bitmap bitmap = contentImgMap.get(logoname);
        manIv.setImageBitmap(bitmap);
        womanIv.setImageBitmap(bitmap);
        return view;
    }
    /*初始化控件*/
    private void initView(View view) {
        manIv = view.findViewById(R.id.parenterfrag_iv_man);
        womanIv = view.findViewById(R.id.parenterfrag_iv_woman);
        mansp = view.findViewById(R.id.parenterfrag_sp_man);
        womansp = view.findViewById(R.id.parenterfrag_sp_woman);
        prizeBtn = view.findViewById(R.id.parenterfrag_btn_prize);
        analysisBtn = view.findViewById(R.id.parenterfrag_btn_analysis);

        /*设置按钮监听*/
        prizeBtn.setOnClickListener(this);
        analysisBtn.setOnClickListener(this);
        mansp.setOnItemSelectedListener(this);
        mansp.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.parenterfrag_btn_prize:

                break;
            case R.id.parenterfrag_btn_analysis:
                //获取spinner选择的位置
                int manpos = mansp.getSelectedItemPosition();
                int womanpos = womansp.getSelectedItemPosition();
                //跳转详情页面
                Intent intent = new Intent(getContext(), ParnterAnalysisActivity.class);
                intent.putExtra("man_name",starinfoBeanList.get(manpos).getName());
                intent.putExtra("man_logoname",starinfoBeanList.get(manpos).getLogoname());
                intent.putExtra("woman_name",starinfoBeanList.get(womanpos).getName());
                intent.putExtra("woman_logoname",starinfoBeanList.get(womanpos).getLogoname());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.parenterfrag_sp_man:
                String logoname = starinfoBeanList.get(i).getLogoname();
                Bitmap bitmap = contentImgMap.get(logoname);
                manIv.setImageBitmap(bitmap);

                break;
            case R.id.parenterfrag_sp_woman:
                logoname = starinfoBeanList.get(i).getLogoname();
                bitmap = contentImgMap.get(logoname);
                womanIv.setImageBitmap(bitmap);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
