package com.niezhiliang.shiro.demo.service.impl;

import com.niezhiliang.shiro.demo.domain.UserExample;
import com.niezhiliang.shiro.demo.mapper.UserMapper;
import com.niezhiliang.shiro.demo.service.UserService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/14 下午6:31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String query() {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdIsNotNull();
        return CommonUtils.successJson(userMapper.selectByExample(example));
    }
}
