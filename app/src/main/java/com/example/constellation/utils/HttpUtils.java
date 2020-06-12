package com.example.constellation.utils;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.utils
 * 文件名： HttpUtils
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 13:41
 * 描述：TODO
 */

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {

    public static String getJSONFromNet(String path){
        String json = "";
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        //1\将路径转换成url对象
        try {
            URL url = new URL(path);
            //2\获取网络连接对象
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //3\开始连接
            connection.connect();
            //4\读取输入流中对象
            InputStream is = connection.getInputStream();
            //5\读取流
            int hasRead = 0;
            byte[] buf = new byte[1024];
            //6\循环读取
            while (true){
                hasRead = is.read(buf);
                if(hasRead == -1){
                    break;
                }
                bs.write(buf,0,hasRead);
            }
            is.close();
            json = bs.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }
}
