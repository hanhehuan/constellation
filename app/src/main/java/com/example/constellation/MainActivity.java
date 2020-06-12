package com.example.constellation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.constellation.bean.StarInfoBean;
import com.example.constellation.fragment.LuckFragment;
import com.example.constellation.fragment.MeFragment;
import com.example.constellation.fragment.ParnterFragment;
import com.example.constellation.fragment.StarFragment;
import com.example.constellation.utils.AssetsUtils;
import com.example.constellation.utils.StaticUtils;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup main_RG;
    private Fragment starFrag,parnterFrag,luckFrag,meFrag;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StaticUtils.NavigationBarStatusBar(this,true);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        main_RG = findViewById(R.id.main_rg);
        main_RG.setOnCheckedChangeListener(this);//设置点击监听

        StarInfoBean starInfoBean = getStarJson();//加在星座相关数据，从assets文件里
        Bundle bundle = new Bundle();
        bundle.putSerializable("info",starInfoBean);

        //======碎片相关======
        starFrag = new StarFragment();
        starFrag.setArguments(bundle);

        parnterFrag = new ParnterFragment();
        parnterFrag.setArguments(bundle);

        luckFrag = new LuckFragment();
        luckFrag.setArguments(bundle);

        meFrag = new MeFragment();
        meFrag.setArguments(bundle);
        //1创建碎片管理者对象
        fragmentManager = getSupportFragmentManager();
        //2创建碎片处理事务的对象
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //3将四个fragment统一的添加到布局当中
        transaction.add(R.id.main_layout_center,starFrag);
        transaction.add(R.id.main_layout_center,parnterFrag);
        transaction.add(R.id.main_layout_center,luckFrag);
        transaction.add(R.id.main_layout_center,meFrag);
        //4隐藏后面的三个
        transaction.hide(parnterFrag);
        transaction.hide(luckFrag);
        transaction.hide(meFrag);
        //5提交碎片改变后的事务
        transaction.commit();

    }
    /*读取assets文件夹下xzcontent.json数据*/
    private StarInfoBean getStarJson() {
        String json = AssetsUtils.getJsonFromAssets(this,"xzcontent/xzcontent.json");
        Gson gson = new Gson();
        StarInfoBean infoBean = gson.fromJson(json, StarInfoBean.class);
        AssetsUtils.saveBitmapFromAssets(this,infoBean);
        return infoBean;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (i){
            case R.id.main_rb_star:
                transaction.hide(parnterFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(starFrag);
                break;
            case R.id.main_rb_parnter:
                transaction.hide(starFrag);
                transaction.hide(luckFrag);
                transaction.hide(meFrag);
                transaction.show(parnterFrag);
                break;
            case R.id.main_rb_luck:
                transaction.hide(starFrag);
                transaction.hide(parnterFrag);
                transaction.hide(meFrag);
                transaction.show(luckFrag);
                break;
            case R.id.main_rb_me:
                transaction.hide(starFrag);
                transaction.hide(parnterFrag);
                transaction.hide(luckFrag);
                transaction.show(meFrag);
                break;
        }
        transaction.commit();
    }
}
