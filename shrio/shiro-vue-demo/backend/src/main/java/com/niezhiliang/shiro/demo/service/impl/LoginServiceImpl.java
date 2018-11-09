package com.niezhiliang.shiro.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.domain.User;
import com.niezhiliang.shiro.demo.domain.UserExample;
import com.niezhiliang.shiro.demo.mapper.UserMapper;
import com.niezhiliang.shiro.demo.service.LoginService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:27
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String userLogin(JSONObject requestJson) {
        String userName = requestJson.getString("userName");
        String password = requestJson.getString("password");
        int rememberMe = requestJson.getIntValue("rememberMe");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            currentUser.login(token);
            return CommonUtils.successJson("登录成功");
        } catch (AuthenticationException e) {
            return CommonUtils.errorJson(ErrorCode.E_101);
        }

    }

    @Override
    public User getUserByUserName(String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(example);
        try {
            return userList.get(0);
        } catch (Exception e) {
            return null;
        }
    }


}
