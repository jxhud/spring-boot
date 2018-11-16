package com.niezhiliang.shiro.demo.domain;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/16 上午8:41
 */
public class TreeView {
    private Menu menu;


    private List<TreeView> treeViews;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<TreeView> getTreeViews() {
        return treeViews;
    }

    public void setTreeViews(List<TreeView> treeViews) {
        this.treeViews = treeViews;
    }
}
