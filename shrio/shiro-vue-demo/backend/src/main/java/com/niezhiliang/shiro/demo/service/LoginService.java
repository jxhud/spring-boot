package com.niezhiliang.shiro.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.domain.User;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:26
 */
public interface LoginService {

    String userLogin(JSONObject requestJson);

    User getUserByUserName(String userName);
}
