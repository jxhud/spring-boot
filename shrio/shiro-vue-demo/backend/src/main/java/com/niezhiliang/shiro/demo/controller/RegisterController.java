package com.niezhiliang.shiro.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.annotation.Log;
import com.niezhiliang.shiro.demo.service.RegisterService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:29
 */
@RequestMapping(value = "register")
@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * 用户注册
     * @return
     */
    @RequestMapping(value = "main")
    @Log(value = "用户注册")
    public String userRegister(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"userName,password");
        return registerService.userRegister(requestJson);
    }
}
