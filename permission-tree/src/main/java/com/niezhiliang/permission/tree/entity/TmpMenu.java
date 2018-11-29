package com.niezhiliang.permission.tree.entity;

import com.niezhiliang.permission.tree.domain.Menu;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午10:36
 */
public class TmpMenu extends Menu {
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
