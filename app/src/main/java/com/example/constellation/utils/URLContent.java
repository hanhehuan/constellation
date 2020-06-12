package com.example.constellation.utils;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.utils
 * 文件名： URLContent
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 13:36
 * 描述：TODO
 */

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLContent {
    //星座配对接口
    public static String getParnterURL(String men,String women){
        men = men.replace("座","");
        women = women.replace("座","");
        try {
            men = URLEncoder.encode(men,"UTF-8");
            women = URLEncoder.encode(women,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = "http://apis.juhe.cn/xzpd/query?key="+StaticUtils.XZPD_KEY+"&men="+men+"&women="+women;
        return url;
    }
    //星座运势配对接口
    public static String getLuckURL(String name){
        try {
            name = URLEncoder.encode(name,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "http://web.juhe.cn:8080/constellation/getAll?key="+StaticUtils.XZYS_KEY+"&consName="+name;
        return url;
    }
}
