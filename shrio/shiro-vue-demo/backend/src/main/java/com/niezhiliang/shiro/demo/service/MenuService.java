package com.niezhiliang.shiro.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.domain.Menu;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午4:06
 */
public interface MenuService {

    String addMenu(JSONObject requestJson);

    String deleteMenu(JSONObject requestJson);

    String updateMenu(JSONObject requestJson);

    String queryMenu(JSONObject requestJson);

    List<Menu> getMenuByRoleId(Integer roleId);

    String tree();
}
