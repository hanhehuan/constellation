package com.example.constellation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.constellation.adapter.LuckAnalysisAdapter;
import com.example.constellation.bean.LuckAnalysisBean;
import com.example.constellation.bean.LuckItemBean;
import com.example.constellation.utils.LoadDataAsyncTask;
import com.example.constellation.utils.URLContent;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LuckAnalysisActivity extends AppCompatActivity implements LoadDataAsyncTask.OnGetNetDataListener, View.OnClickListener {
    ListView luckLv;
    TextView nameTv;
    ImageView backIv;
    List<LuckItemBean> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_analysis);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");//获取上一级传的星座名称

        String luckURL = URLContent.getLuckURL(name);

        luckLv = findViewById(R.id.luck_lv);
        nameTv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        nameTv.setText(name);
        backIv.setOnClickListener(this);

        mDatas = new ArrayList<>();

        LoadDataAsyncTask asyncTask = new LoadDataAsyncTask(this, this, true);
        asyncTask.execute(luckURL);
    }
    //获取网络成功后返回的数据
    @Override
    public void onSuccess(String json) {
        if(!TextUtils.isEmpty(json)){
            //数据解析
            LuckAnalysisBean luckAnalysisBean = new Gson().fromJson(json, LuckAnalysisBean.class);
            addDataToList(luckAnalysisBean);
            LuckAnalysisAdapter adapter = new LuckAnalysisAdapter(this, mDatas);
            luckLv.setAdapter(adapter);
        }
    }

    private void addDataToList(LuckAnalysisBean luckAnalysisBean) {
        LuckItemBean bean1 = new LuckItemBean("综合运势", luckAnalysisBean.getYear().getMima().getText().get(0), Color.BLUE);
        LuckItemBean bean2 = new LuckItemBean("爱情运势", luckAnalysisBean.getYear().getLove().get(0),Color.GREEN);
        LuckItemBean bean3 = new LuckItemBean("事业学业", luckAnalysisBean.getYear().getCareer().get(0),Color.RED);
        LuckItemBean bean4 = new LuckItemBean("健康运势", luckAnalysisBean.getYear().getHealth().get(0),Color.GRAY);
        LuckItemBean bean5 = new LuckItemBean("财富运势", luckAnalysisBean.getYear().getFinance().get(0),Color.BLACK);
        mDatas.add(bean1);
        mDatas.add(bean2);
        mDatas.add(bean3);
        mDatas.add(bean4);
        mDatas.add(bean5);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_iv_back:
                finish();
                break;
        }
    }
}
