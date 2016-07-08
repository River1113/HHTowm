package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class SortSubListBean {


    private int cat_id;
    private String name;
    private String logo;

    public SortSubListBean() {

    }

    public SortSubListBean(int cat_id, String name, String logo) {
        this.cat_id = cat_id;
        this.name = name;
        this.logo = logo;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
