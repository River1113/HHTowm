package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/6/29.
 */
public class HomeBannerBean {

    /**
     * home页面横幅
     */

    private String logo;
    private String logo2;
    private String type;
    private String name;
    private String desc;
    private String id;
    private String url;

    public HomeBannerBean() {

    }

    public HomeBannerBean(String logo, String logo2, String type, String name, String desc, String id, String url) {
        this.logo = logo;
        this.logo2 = logo2;
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.id = id;
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo2() {
        return logo2;
    }

    public void setLogo2(String logo2) {
        this.logo2 = logo2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HomeBannerBean{" +
                "logo='" + logo + '\'' +
                ", logo2='" + logo2 + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
