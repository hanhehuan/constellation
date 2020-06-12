package com.example.constellation.utils;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.utils
 * 文件名： AssetsUtils
 * 创建者：hanhehuann
 * 创建时间：2020-05-26 14:08
 * 描述：TODO
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.constellation.bean.StarInfoBean;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读取assets文件夹下文件的工具类
 */
public class AssetsUtils {

    private static Map<String,Bitmap> logoImgMap;
    private static Map<String,Bitmap> contentImgMap;

    /*读取assets文件夹中的内容，存放到字符串当中*/
    public static String getJsonFromAssets(Context context,String filename){
        //1.获取assets文件夹管理器
        AssetManager am = context.getResources().getAssets();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //2.获取输入流
        try {
            InputStream is = am.open(filename);
            //获取内容存到内存流当中
            int hasRead = 0;
            byte[] buf = new byte[1024];
            while (true){
                hasRead = is.read(buf);
                if(hasRead == -1){
                    break;
                }
                baos.write(buf,0,hasRead);
            }
            String msg = baos.toString();
            is.close();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*读取assets文件夹下的图片，返回bitmap对象*/
    public static Bitmap getBitmapFromAssets(Context context,String filename){
        Bitmap bitmap = null;
        //获取文件夹管理器
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(filename);
            //通过位图管理器，将输入流转换为位图对象
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return bitmap;

    }

    /*一块读取assets文件夹下的图片，放到内存当中便于管理*/
    public static void saveBitmapFromAssets(Context context, StarInfoBean starInfoBean){
        logoImgMap = new HashMap<>();
        contentImgMap = new HashMap<>();
        List<StarInfoBean.StarinfoBean> starList = starInfoBean.getStarinfo();
        for(int i=0;i<starList.size();i++){
            String logoname = starList.get(i).getLogoname();
            String filename = "xzlogo/"+logoname+".png";
            Bitmap logoBm = getBitmapFromAssets(context,filename);
            logoImgMap.put(logoname,logoBm);

            String contentName = "xzcontentlogo/"+logoname+".png";
            Bitmap bitmap = getBitmapFromAssets(context,contentName);
            contentImgMap.put(logoname,bitmap);
        }
    }

    public static Map<String, Bitmap> getLogoImgMap() {
        return logoImgMap;
    }

    public static Map<String, Bitmap> getContentImgMap() {
        return contentImgMap;
    }
}
