package com.niezhiliang.shiro.demo.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午3:43
 */
public interface DeptService {

    String addDept(JSONObject requestJson);

    String deleteDept(JSONObject requestJson);

    String selectDept(JSONObject requestJson);

    String updateDept(JSONObject requestJson);
}
