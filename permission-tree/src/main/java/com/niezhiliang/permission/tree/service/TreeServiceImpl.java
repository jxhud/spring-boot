package com.niezhiliang.permission.tree.service;

import com.niezhiliang.permission.tree.entity.MenuTree;
import com.niezhiliang.permission.tree.entity.RoleMenuInfo;
import com.niezhiliang.permission.tree.mapper.MenuMapper;
import com.niezhiliang.permission.tree.mapper.RoleMapper;
import com.niezhiliang.permission.tree.mapper.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午8:57
 */
@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleMenuInfo> getRoleMenu() {
        return roleMenuMapper.getRoleInfo();
    }

    @Override
    public List<MenuTree> getMenus(Integer roleId) {
        return menuMapper.getMenus(roleId);
    }

    @Override
    public List<RoleMenuInfo> getMenu(Integer roleId) {
        return roleMapper.selectSubMenu(roleId);
    }
}
