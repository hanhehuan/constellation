package com.example.constellation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.constellation.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    ViewPager guide_vp;
    //存放三张图片的地址
    int resIds[] = {R.mipmap.loading1,R.mipmap.loading2,R.mipmap.loading3};
    List<ImageView> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        guide_vp = findViewById(R.id.guid_vp);
        mDatas = new ArrayList<>();
        initPages();
        //为三个图片设置监听
        setListenter();
    }

    private void setListenter() {
        int size = mDatas.size();
        ImageView imageView = mDatas.get(size - 1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void initPages() {
        for (int i=0;i<resIds.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(resIds[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(lp);
            mDatas.add(imageView);
        }

        GuideAdapter guideAdapter = new GuideAdapter(mDatas);
        guide_vp.setAdapter(guideAdapter);

    }
}
