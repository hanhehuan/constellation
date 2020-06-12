package com.example.constellation.bean;
/*
 * 项目名： constellation
 * 包名： com.example.constellation.bean
 * 文件名： StarAnalysisBean
 * 创建者：hanhehuann
 * 创建时间：2020-05-27 14:09
 * 描述：TODO
 */

public class StarAnalysisBean {
    private String title;
    private String content;
    private int color;

    public StarAnalysisBean(String title, String content, int color) {
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
