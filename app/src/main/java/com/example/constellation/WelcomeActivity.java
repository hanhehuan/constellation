package com.example.constellation;
/*
 * 项目名： constellation
 * 包名： com.example.constellation
 * 文件名： WelcomeActivity
 * 创建者：hanhehuann
 * 创建时间：2020-05-29 9:46
 * 描述：TODO
 */

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    TextView tv;
    int count = 5;
    private SharedPreferences pref;

    Handler handler = new Handler(){
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                count--;
                if (count==0){
                    //判断是否是第一次使用应用
                    boolean isFirst = pref.getBoolean("isFirst", true);
                    Intent intent = new Intent();
                    if (isFirst){
                        intent.setClass(WelcomeActivity.this,GuideActivity.class);
                        //为了下一次不进入引导页
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putBoolean("isFirst",false);
                        edit.commit();
                    }else {
                        intent.setClass(WelcomeActivity.this,MainActivity.class);
                    }

                    startActivity(intent);
                    finish();
                }else {
                    tv.setText(String.valueOf(count));
                    handler.sendEmptyMessageDelayed(1,500);
                }
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tv = findViewById(R.id.welcome_tv);
        pref = getSharedPreferences("first_pref", MODE_PRIVATE);
        handler.sendEmptyMessageDelayed(1,500);
    }
}
