package com.example.constellation.bean;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.bean
 * 文件名： LuckItemBean
 * 创建者：hanhehuann
 * 创建时间：2020-05-28 16:52
 * 描述：TODO
 */

public class LuckItemBean {
    private String title;
    private String content;
    private int color;

    public LuckItemBean(String title, String content, int color) {
        this.title = title;
        this.content = content;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
