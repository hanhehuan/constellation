package com.example.constellation;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.constellation.bean.ParnterAnalysisBean;
import com.example.constellation.utils.AssetsUtils;
import com.example.constellation.utils.LoadDataAsyncTask;
import com.example.constellation.utils.URLContent;
import com.google.gson.Gson;

import java.util.Map;

public class ParnterAnalysisActivity extends AppCompatActivity implements LoadDataAsyncTask.OnGetNetDataListener, View.OnClickListener {
    private TextView mantv,womantv,pdtv,vstv,pftv,bztv,jxtv,zytv,titletv;
    private CircleImageView manIv,womanIv;
    private ImageView backIv;
    private String man_name;
    private String man_logoname;
    private String woman_name;
    private String woman_logoname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parnter_analysis);

        initView();
        //接收上一个页面传过来的数据
        getLastData();
        //获取网络加载地址
        String parnterUrl = URLContent.getParnterURL(man_name,woman_name);
        //加载网络数据
        //1、创造自定义的异步任务对象
        LoadDataAsyncTask asyncTask = new LoadDataAsyncTask(this, this, true);
        //2、执行异步任务
        asyncTask.execute(parnterUrl);
    }

    @Override
    public void onSuccess(String json) {
        if(!TextUtils.isEmpty(json)){
            ParnterAnalysisBean parnterAnalysisBean = new Gson().fromJson(json, ParnterAnalysisBean.class);
            ParnterAnalysisBean.ResultBean result = parnterAnalysisBean.getResult();
            int error_code = parnterAnalysisBean.getError_code();
            if (error_code == 0){
                pftv.setText("配对评分："+result.getZhishu()+"  "+result.getJieguo());
                bztv.setText("星座比重："+result.getBizhong());
                jxtv.setText("解析：\n\n"+result.getLianai());
                zytv.setText("注意事项：\n\n"+result.getZhuyi());
            }

        }
    }

    private void getLastData() {
        Intent intent = getIntent();
        man_name = intent.getStringExtra("man_name");
        man_logoname = intent.getStringExtra("man_logoname");
        woman_name = intent.getStringExtra("woman_name");
        woman_logoname = intent.getStringExtra("woman_logoname");
        //设置能展示的信息
        Map<String, Bitmap> contentImgMap = AssetsUtils.getContentImgMap();
        Bitmap bitmap = contentImgMap.get(man_logoname);
        manIv.setImageBitmap(bitmap);
        Bitmap woman_bitmap = contentImgMap.get(woman_logoname);
        womanIv.setImageBitmap(woman_bitmap);

        mantv.setText(man_name);
        womantv.setText(woman_name);

        pdtv.setText("星座配对-"+man_name+"和"+woman_name+"配对");
        vstv.setText(man_name+" vs "+woman_name);


    }

    private void initView() {
        mantv = findViewById(R.id.tv_man);
        womantv = findViewById(R.id.tv_woman);
        pdtv = findViewById(R.id.tv_pd);
        vstv = findViewById(R.id.tv_vs);
        pftv = findViewById(R.id.tv_pf);
        bztv = findViewById(R.id.tv_bz);
        jxtv = findViewById(R.id.tv_jx);
        zytv = findViewById(R.id.tv_zy);
        titletv = findViewById(R.id.title_tv);
        backIv = findViewById(R.id.title_iv_back);
        manIv = findViewById(R.id.parnteranaly_iv_man);
        womanIv = findViewById(R.id.parnteranaly_iv_woman);

        backIv.setOnClickListener(this);
        titletv.setText("配对详情");

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
