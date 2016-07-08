package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class SortCatListBean {
    private int cat_id;
    private String name;
    private String logo;
    private int parent_id;
    private int is_list;

    public SortCatListBean() {

    }

    public SortCatListBean(int cat_id, String name, String logo, int parent_id, int is_list) {
        this.cat_id = cat_id;
        this.name = name;
        this.logo = logo;
        this.parent_id = parent_id;
        this.is_list = is_list;
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

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getIs_list() {
        return is_list;
    }

    public void setIs_list(int is_list) {
        this.is_list = is_list;
    }
}
