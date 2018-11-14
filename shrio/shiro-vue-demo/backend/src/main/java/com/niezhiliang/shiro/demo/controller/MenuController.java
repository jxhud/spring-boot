package com.niezhiliang.shiro.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.annotation.Log;
import com.niezhiliang.shiro.demo.service.MenuService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午2:47
 */
@RequestMapping(value = "menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "add")
    @RequiresPermissions("menu:add")
    @Log(value = "添加菜单")
    public String add(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"menuName,permissions");
        return menuService.addMenu(requestJson);
    }

    @RequestMapping(value = "delete")
    @Log(value = "删除菜单")
    public String delete(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"id");
        return menuService.deleteMenu(requestJson);
    }

    @RequestMapping(value = "update")
    @Log(value = "修改菜单")
    public String update(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"id");
        return menuService.updateMenu(requestJson);
    }

    @RequestMapping(value = "query")
    @Log(value = "查询菜单列表")
    public String query() {
        JSONObject requestJson = new JSONObject();
        return menuService.queryMenu(requestJson);
    }
}
