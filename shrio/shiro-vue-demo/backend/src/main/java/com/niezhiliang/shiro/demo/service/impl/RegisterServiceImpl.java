package com.niezhiliang.shiro.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.domain.User;
import com.niezhiliang.shiro.demo.mapper.UserMapper;
import com.niezhiliang.shiro.demo.service.RegisterService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:32
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String userRegister(JSONObject requestJson) {
        User user = new User();
        user.setUserName(requestJson.getString("userName"));
        user.setPassword(new BCryptPasswordEncoder().encode(requestJson.getString("password")));
        user.setCreateTime(new Date());
        int i = userMapper.insertSelective(user);
        if (i > 0) {
            return CommonUtils.successJson("注册成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }
}
