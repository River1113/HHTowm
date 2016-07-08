package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class FindGridBean {
    private String imgUrl;
    private String ImgName;

    public FindGridBean() {

    }

    public FindGridBean(String imgUrl, String imgName) {
        this.imgUrl = imgUrl;
        ImgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgName() {
        return ImgName;
    }

    public void setImgName(String imgName) {
        ImgName = imgName;
    }
}
