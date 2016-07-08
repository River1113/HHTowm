package com.myapplication.Bean;

import java.util.List;

/**
 * @author Administrator
 * @date 2016/7/4.
 */
public class FindListBean {
    private String title;
    private List<FindGridBean> findGridBeanList;
    public FindListBean() {

    }

    public FindListBean(String title, List<FindGridBean> findGridBeanList) {
        this.title = title;
        this.findGridBeanList = findGridBeanList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FindGridBean> getFindGridBeanList() {
        return findGridBeanList;
    }

    public void setFindGridBeanList(List<FindGridBean> findGridBeanList) {
        this.findGridBeanList = findGridBeanList;
    }
}
