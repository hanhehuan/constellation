package com.example.constellation;
/*
 * 项目名： constellation
 * 包名： com.example.constellation
 * 文件名： StarAnalysisActivity
 * 创建者：hanhehuann
 * 创建时间：2020-05-26 17:11
 * 描述：TODO
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.constellation.adapter.AnalysisBeanAdapter;
import com.example.constellation.bean.StarAnalysisBean;
import com.example.constellation.bean.StarInfoBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class StarAnalysisActivity extends AppCompatActivity implements View.OnClickListener {
    TextView titleTv;
    ImageView backIv;
    CircleImageView iconIv;
    TextView nameTv,dateTv;
    ListView analysisLv;
    StarInfoBean.StarinfoBean bean;
    private Map<String, Bitmap> contentImgMap;
    private TextView foottv;
    List<StarAnalysisBean> mDatas;
    private AnalysisBeanAdapter analysisBeanAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_analysis);
        //获取上一级传递过来的数据
        Intent intent = getIntent();
        bean = (StarInfoBean.StarinfoBean) intent.getSerializableExtra("star");
        initView();
        initData();
    }

    private void initData() {
        mDatas = new ArrayList<>();
        analysisBeanAdapter = new AnalysisBeanAdapter(this, mDatas);
        analysisLv.setAdapter(analysisBeanAdapter);

        addDataToList();
    }
    /*加载listview当中的数据源内容*/
    private void addDataToList() {
        StarAnalysisBean bean1 = new StarAnalysisBean("性格特点", bean.getTd(),R.color.lightblue);
        StarAnalysisBean bean2 = new StarAnalysisBean("掌管宫位", bean.getGw(),R.color.lightpink);
        StarAnalysisBean bean3 = new StarAnalysisBean("显阴阳性", bean.getYy(),R.color.lightgreen);
        StarAnalysisBean bean4 = new StarAnalysisBean("最大特性", bean.getTz(),R.color.purple);
        StarAnalysisBean bean5 = new StarAnalysisBean("主管星球", bean.getZg(),R.color.orange);
        StarAnalysisBean bean6 = new StarAnalysisBean("幸运颜色", bean.getYs(),R.color.colorAccent);
        StarAnalysisBean bean7 = new StarAnalysisBean("搭配珠宝", bean.getZb(),R.color.colorPrimary);
        StarAnalysisBean bean8 = new StarAnalysisBean("幸运号码", bean.getHm(),R.color.grey);
        StarAnalysisBean bean9 = new StarAnalysisBean("搭配金属", bean.getJs(),R.color.darkblue);

        mDatas.add(bean1);
        mDatas.add(bean2);
        mDatas.add(bean3);
        mDatas.add(bean4);
        mDatas.add(bean5);
        mDatas.add(bean6);
        mDatas.add(bean7);
        mDatas.add(bean8);
        mDatas.add(bean9);
        //数据源发生变化，通知适配器改变
        analysisBeanAdapter.notifyDataSetChanged();

    }

    private void initView() {
        titleTv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        iconIv = findViewById(R.id.staranalysis_iv);
        nameTv = findViewById(R.id.staranalysis_tv_name);
        dateTv = findViewById(R.id.staranalysis_tv_date);
        analysisLv = findViewById(R.id.staranalysis_lv);
        //为listview添加底部布局
        View footview = LayoutInflater.from(this).inflate(R.layout.footer_star_analysis, null);
        analysisLv.addFooterView(footview);
        foottv = footview.findViewById(R.id.footstar_tv_info);
        //有数据进行显示
        titleTv.setText("星座详情");
        nameTv.setText(bean.getName());
        dateTv.setText(bean.getDate());
        contentImgMap = AssetsUtils.getContentImgMap();
        Bitmap bitmap = contentImgMap.get(bean.getLogoname());
        iconIv.setImageBitmap(bitmap);
        foottv.setText(bean.getInfo());

        backIv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
