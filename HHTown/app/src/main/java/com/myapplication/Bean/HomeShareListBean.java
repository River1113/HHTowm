package com.myapplication.Bean;

/**
 * @author Administrator
 * @date 2016/7/1.
 */
public class HomeShareListBean {

    /**
     *
     */

    private String share_id;
    private String desc;
    private int is_strategy;
    private String name;
    private String price;
    private String original_price;
    private int is_free_shipping;
    private String like;
    private int low;
    private String url;
    private String goods_url;
    private String source;
    private String baike_url;
    private String best_desc;
    private String external_id;
    private String source_title;
    private String detail_logo;
    private String icon;

    public HomeShareListBean() {
    }

    public HomeShareListBean(String share_id, String desc, int is_strategy, String name, String price, String original_price, int is_free_shipping,
                             String like, int low, String url, String goods_url, String source, String baike_url, String best_desc,
                             String external_id, String source_title, String detail_logo, String icon) {
        this.share_id = share_id;
        this.desc = desc;
        this.is_strategy = is_strategy;
        this.name = name;
        this.price = price;
        this.original_price = original_price;
        this.is_free_shipping = is_free_shipping;
        this.like = like;
        this.low = low;
        this.url = url;
        this.goods_url = goods_url;
        this.source = source;
        this.baike_url = baike_url;
        this.best_desc = best_desc;
        this.external_id = external_id;
        this.source_title = source_title;
        this.detail_logo = detail_logo;
        this.icon = icon;
    }

    public String getShare_id() {
        return share_id;
    }

    public void setShare_id(String share_id) {
        this.share_id = share_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIs_strategy() {
        return is_strategy;
    }

    public void setIs_strategy(int is_strategy) {
        this.is_strategy = is_strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public int getIs_free_shipping() {
        return is_free_shipping;
    }

    public void setIs_free_shipping(int is_free_shipping) {
        this.is_free_shipping = is_free_shipping;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGoods_url() {
        return goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getBaike_url() {
        return baike_url;
    }

    public void setBaike_url(String baike_url) {
        this.baike_url = baike_url;
    }

    public String getBest_desc() {
        return best_desc;
    }

    public void setBest_desc(String best_desc) {
        this.best_desc = best_desc;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getSource_title() {
        return source_title;
    }

    public void setSource_title(String source_title) {
        this.source_title = source_title;
    }

    public String getDetail_logo() {
        return detail_logo;
    }

    public void setDetail_logo(String detail_logo) {
        this.detail_logo = detail_logo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
