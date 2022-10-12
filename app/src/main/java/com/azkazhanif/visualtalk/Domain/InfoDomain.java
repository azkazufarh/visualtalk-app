package com.azkazhanif.visualtalk.Domain;

import java.io.Serializable;

public class InfoDomain implements Serializable {
    private String title, category, date, img, desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public InfoDomain(String title, String category, String date, String img, String desc) {
        this.title = title;
        this.category = category;
        this.date = date;
        this.img = img;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
