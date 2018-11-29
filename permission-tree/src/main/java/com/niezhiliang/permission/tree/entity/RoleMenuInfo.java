package com.niezhiliang.permission.tree.entity;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午8:43
 */
public class RoleMenuInfo {
    private Integer roleId;

    private String roleName;

    private List<MenuTree> menuList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<MenuTree> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuTree> menuList) {
        this.menuList = menuList;
    }
}
