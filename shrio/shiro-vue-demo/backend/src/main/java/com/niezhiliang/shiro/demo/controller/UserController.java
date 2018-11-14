package com.niezhiliang.shiro.demo.controller;

import com.niezhiliang.shiro.demo.domain.User;
import com.niezhiliang.shiro.demo.service.UserService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/14 下午4:56
 */
@RequestMapping(value = "user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "curryInfo")
    public String getUserInfo() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return CommonUtils.successJson(user);
    }

    @RequestMapping(value = "query")
    public String query() {
        return userService.query();
    }
}
