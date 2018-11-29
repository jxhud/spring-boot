package com.niezhiliang.permission.tree.entity;

import com.niezhiliang.permission.tree.domain.Menu;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午9:29
 */
public class MenuTree extends Menu {

    private List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "MenuTree{" +
                "menuList=" + menuList +
                '}';
    }
}
