package com.smnadim21.bdarchilogy;

public class CatItem {

    private String title,desc,image,loc;
    Integer imageres;

    public CatItem(String title, String desc, String image, String loc) {
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.loc = loc;
    }

    public Integer getImageres() {
        return imageres;
    }

    public void setImageres(Integer imageres) {
        this.imageres = imageres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
