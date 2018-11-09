package com.niezhiliang.shiro.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.annotation.Log;
import com.niezhiliang.shiro.demo.service.RoleService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午2:47
 */
@RequestMapping(value = "role")
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "add")
    @Log(value = "添加角色")
    public String add(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"roleName");
        return roleService.addRole(requestJson);
    }

    @RequestMapping(value = "delete")
    @Log(value = "删除角色")
    public String delete(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"id");
        return roleService.deleteRole(requestJson);
    }

    @RequestMapping(value = "update")
    @Log(value = "编辑角色")
    public String update(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"id,roleName");
        return roleService.updateRole(requestJson);
    }

    @RequestMapping(value = "query")
    @Log(value = "查询角色列表")
    public String query(@RequestBody JSONObject requestJson) {
        return roleService.selectRole(requestJson);
    }
}
