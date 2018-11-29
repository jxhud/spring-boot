package com.niezhiliang.permission.tree.controller;

import com.niezhiliang.permission.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/29 上午9:51
 */
@RestController
public class TestController {
    @Autowired
    private TreeService treeService;

    @RequestMapping(value = "getmenus")
    public Object getMenus(Integer roleId) {
        return treeService.getMenus(roleId);
    }

    @RequestMapping(value = "getMenu")
    public Object getMenu(Integer roleId) {
        return treeService.getMenu(roleId);
    }
}
