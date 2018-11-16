package com.niezhiliang.shiro.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.domain.Menu;
import com.niezhiliang.shiro.demo.domain.MenuExample;
import com.niezhiliang.shiro.demo.domain.MenuTree;
import com.niezhiliang.shiro.demo.domain.TreeView;
import com.niezhiliang.shiro.demo.mapper.MenuMapper;
import com.niezhiliang.shiro.demo.service.MenuService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午4:07
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public String addMenu(JSONObject requestJson) {
        Menu menu = requestJson.toJavaObject(Menu.class);
        menu.setCreateTime(new Date());
        int i = menuMapper.insertSelective(menu);
        if (i > 0) {
            return CommonUtils.successJson("添加成功",menu);
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    public String deleteMenu(JSONObject requestJson) {
        int i = menuMapper.deleteByPrimaryKey(requestJson.getIntValue("id"));
        if (i > 0) {
            return CommonUtils.successJson("删除成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    public String updateMenu(JSONObject requestJson) {
        Menu menu = requestJson.toJavaObject(Menu.class);
        menu.setCreateTime(new Date());
        int i = menuMapper.updateByPrimaryKeySelective(menu);
        if (i > 0) {
            return CommonUtils.successJson("修改成功",menu);
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    public String queryMenu(JSONObject requestJson) {
        MenuExample example = new MenuExample();
        example.createCriteria().andIdIsNotNull();
        List<Menu> menus = menuMapper.selectByExample(example);
        return CommonUtils.successJson(menus);
    }

    @Override
    public List<Menu> getMenuByRoleId(Integer roleId) {
        return menuMapper.getMenuByRoleId(roleId);
    }

    @Override
    public String tree() {
        List<Menu> menuList = menuMapper.getParentMenu();
        MenuTree treeView =  recursion(menuList);
        treeView.setTitle("请选择");
        return CommonUtils.successJson(treeView);
    }

    /**
     * 权限树查询
     * @param menus
     * @return
     */
//    public TreeView recursion(List<Menu> menus) {
//        TreeView treeView = new TreeView();
//        if (menus.isEmpty()) {
//            return  treeView;
//        } else {
//            List<TreeView> treeViewList = new ArrayList<>();
//            for (Menu menu : menus) {
//                TreeView childTreeView = new TreeView();
//                childTreeView.setMenu(menu);
//                List<Menu> menuList = menuMapper.selectChildMenu(menu.getId());
//                childTreeView.setTreeViews(recursion(menuList).getTreeViews());
//                treeViewList.add(childTreeView);
//            }
//            treeView.setTreeViews(treeViewList);
//            return treeView;
//        }
//
//    }

    public MenuTree recursion(List<Menu> menus) {
        MenuTree menuTree = new MenuTree();
        if (menus.isEmpty()) {
            return menuTree;
        } else {
            List<MenuTree> menuTrees = new ArrayList<>();
            for (Menu menu : menus) {
                MenuTree treeMenus = new MenuTree();
                treeMenus.setTitle(menu.getMenuName());
                List<Menu> menuList = menuMapper.selectChildMenu(menu.getId());
                treeMenus.setChildren(recursion(menuList).getChildren());
                menuTrees.add(treeMenus);

            }
            menuTree.setChildren(menuTrees);
        }
        return menuTree;
    }
}
