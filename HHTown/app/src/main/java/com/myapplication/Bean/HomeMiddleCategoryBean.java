package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/6/30.
 */
public class HomeMiddleCategoryBean {

    /**
     * @type : com.mobile.api.network.model.CategoryInfo
     * icon : http://www.hehe168.com/public/upload/images/201601/29/56ab3de7e90df.png
     * cat_id : 300
     * name : 热门发现
     * desc : 喜气洋洋过大节
     */

    private String icon;
    private String cat_id;
    private String name;
    private String desc;

    public HomeMiddleCategoryBean() {
    }

    public HomeMiddleCategoryBean(String icon, String name, String desc) {
        this.icon = icon;
        this.name = name;
        this.desc = desc;
    }

    public HomeMiddleCategoryBean(String icon, String cat_id, String name, String desc) {
        this.icon = icon;
        this.cat_id = cat_id;
        this.name = name;
        this.desc = desc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
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
}
