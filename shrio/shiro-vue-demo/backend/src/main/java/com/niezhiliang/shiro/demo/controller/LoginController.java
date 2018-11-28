package com.niezhiliang.shiro.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.service.LoginService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    /**
     * 登录
     * @param requestJson
     * @return
     */
    @RequestMapping(value = "in")
    public String login(@RequestBody JSONObject requestJson) {
        CommonUtils.hasAllRequired(requestJson,"userName,password");
        return loginService.userLogin(requestJson);
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "out")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return CommonUtils.successJson("登出成功");
    }


}
