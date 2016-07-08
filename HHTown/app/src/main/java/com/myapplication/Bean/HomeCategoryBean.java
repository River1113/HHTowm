package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/6/30.
 */
public class HomeCategoryBean {

    /**
     * @type : com.mobile.api.network.model.CategoryInfo
     * type : 1
     * id : 254
     * category : {"cat_id":"254"}
     * is_list : 1
     * cat_id : 254
     * logo : http://www.hehe168.com/public/upload/m/201603/16/56e92d4cc7e1a.png
     * icon : http://www.hehe168.com/public/upload/m/201603/16/56e92d4cc7e1a.png
     * is_red : false
     * name : 特价好货
     * desc :
     * m_index_id : 18
     */

    private String type;
    private String id;
    private String is_list;
    private String cat_id;
    private String logo;
    private String icon;
    private boolean is_red;
    private String name;
    private String desc;
    private String m_index_id;

    public HomeCategoryBean() {

    }

    public HomeCategoryBean(String icon, String name) {
        this.icon = icon;
        this.name = name;
    }


    public HomeCategoryBean(String type, String id, String is_list, String cat_id, String logo,
                            String icon, boolean is_red, String name, String desc, String m_index_id) {
        this.type = type;
        this.id = id;
        this.is_list = is_list;
        this.cat_id = cat_id;
        this.logo = logo;
        this.icon = icon;
        this.is_red = is_red;
        this.name = name;
        this.desc = desc;
        this.m_index_id = m_index_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_list() {
        return is_list;
    }

    public void setIs_list(String is_list) {
        this.is_list = is_list;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isIs_red() {
        return is_red;
    }

    public void setIs_red(boolean is_red) {
        this.is_red = is_red;
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

    public String getM_index_id() {
        return m_index_id;
    }

    public void setM_index_id(String m_index_id) {
        this.m_index_id = m_index_id;
    }
}
