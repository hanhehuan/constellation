package com.example.constellation.fragment;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import de.hdodenhof.circleimageview.CircleImageView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.adapter.LuckAnalysisAdapter;
import com.example.constellation.adapter.LuckBaseAdapter;
import com.example.constellation.bean.StarInfoBean;
import com.example.constellation.utils.AssetsUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {

    CircleImageView nameCv;
    TextView nameTv;
    private StarInfoBean info;
    private Map<String, Bitmap> contentImgMap;
    private List<StarInfoBean.StarinfoBean> mDatas;
    private SharedPreferences star_pref;
    //保存选择的星座
    int selectPos = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取activity传递的数据
        Bundle bundle = getArguments();
        StarInfoBean info = (StarInfoBean) bundle.getSerializable("info");
        mDatas = info.getStarinfo();
        star_pref = getContext().getSharedPreferences("star_pref", Context.MODE_PRIVATE);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        nameCv = view.findViewById(R.id.mefrag_iv);
        nameTv = view.findViewById(R.id.mefrag_name_tv);
        //进行初始化设置
        contentImgMap = AssetsUtils.getContentImgMap();
        //读取共享参数中的星座名称
        String name = star_pref.getString("name", "白羊座");
        String logoname = star_pref.getString("logoname", "baiyang");

        Bitmap bitmap = contentImgMap.get(logoname);
        nameCv.setImageBitmap(bitmap);
        nameTv.setText(name);
        nameCv.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mefrag_iv:
                showDialog();
                break;
        }
    }

    private void showDialog() {

        final Dialog dialog = new Dialog(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.me_dialog,null);
        dialog.setContentView(view);
        dialog.setTitle("请选择您的星座：");
        GridView gv = view.findViewById(R.id.mefrag_dialog_gv);
        //设置适配器
        LuckBaseAdapter adapter = new LuckBaseAdapter(getContext(), mDatas);
        gv.setAdapter(adapter);
        //设置能否被取消
        dialog.setCancelable(true);
        //设置点击弹窗的外部能否被取消
        dialog.setCanceledOnTouchOutside(true);
        //设置GridView的每一项点击监听
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                StarInfoBean.StarinfoBean bean = mDatas.get(i);
                String name = bean.getName();
                String logoname = bean.getLogoname();
                nameTv.setText(name);
                Bitmap bitmap = contentImgMap.get(logoname);
                nameCv.setImageBitmap(bitmap);
                selectPos = i;//保存选择的位置
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        StarInfoBean.StarinfoBean starinfoBean = mDatas.get(selectPos);
        String name = starinfoBean.getName();
        String logoname = starinfoBean.getLogoname();
        SharedPreferences.Editor edit = star_pref.edit();
        edit.putString("name",name);
        edit.putString("logoname",logoname);
        edit.commit();
    }
}
