package com.niezhiliang.shiro.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.service.LoginService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午10:13
 */
@RequestMapping(value = "login")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "in")
    public String login(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"userName,password,rememberMe");
        return loginService.userLogin(requestJson);
    }
}
