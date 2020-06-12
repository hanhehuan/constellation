package com.example.constellation.utils;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.utils
 * 文件名： LoadDataAsyncTask
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 13:50
 * 描述：TODO
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

public class LoadDataAsyncTask extends AsyncTask<String,Void,String> {


    public interface OnGetNetDataListener{
        void onSuccess(String json);
    }

    Context context;
    OnGetNetDataListener listener;
    boolean isShowDialog = false;
    ProgressDialog dialog;
    private void initDialog(){
        dialog = new ProgressDialog(context);
        dialog.setTitle("提示信息");
        dialog.setMessage("正在加载中......");

    }
    public LoadDataAsyncTask(Context context, OnGetNetDataListener listener,boolean isShowDialog) {
        this.context = context;
        this.listener = listener;
        this.isShowDialog = isShowDialog;
        initDialog();
    }

    //运行在主线程，通常在此方法中进行控件的初始化
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (isShowDialog){
            dialog.show();
        }

    }
    //运行在子线程中，通常在此方法中进行耗时操作
    @Override
    protected String doInBackground(String... params) {
        String json = HttpUtils.getJSONFromNet(params[0]);
        return json;
    }
    //运行在主线程，可以在此处得到doInBackground返回的数据，在此处进行控件的更新
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if (isShowDialog){
            dialog.dismiss();
        }
        listener.onSuccess(s);
    }
}
