package com.niezhiliang.shiro.demo.domain;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/16 上午11:19
 */
public class MenuTree {
    private int id;

    private String title;

    private List<MenuTree> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
}
