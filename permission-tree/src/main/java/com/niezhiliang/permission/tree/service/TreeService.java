package com.niezhiliang.permission.tree.service;

import com.niezhiliang.permission.tree.entity.MenuTree;
import com.niezhiliang.permission.tree.entity.RoleMenuInfo;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午8:57
 */
public interface TreeService {

    List<RoleMenuInfo> getRoleMenu();

    List<MenuTree> getMenus(Integer roleId);

    List<RoleMenuInfo> getMenu(Integer roleId);

}
