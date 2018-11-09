package com.niezhiliang.shiro.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.domain.Role;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午3:56
 */
public interface RoleService {

    List<Role> getUserRoleByUserId(Integer userId);

    String addRole(JSONObject requestJson);

    String deleteRole(JSONObject requestJson);

    String selectRole(JSONObject requestJson);

    String updateRole(JSONObject requestJson);
}
