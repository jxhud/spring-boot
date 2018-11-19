package com.niezhiliang.shiro.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.domain.*;
import com.niezhiliang.shiro.demo.mapper.RoleMapper;
import com.niezhiliang.shiro.demo.mapper.RoleMenuMapper;
import com.niezhiliang.shiro.demo.mapper.UserRoleMapper;
import com.niezhiliang.shiro.demo.service.RoleService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午3:56
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<Role> getUserRoleByUserId(Integer userId) {
        return roleMapper.getUserRoleByUserId(userId);
    }

    @Override
    @Transactional
    public String addRole(JSONObject requestJson) {
        Role role = requestJson.toJavaObject(Role.class);
        int i = roleMapper.insertSelective(role);
        if (i > 0) {
            List<Integer>  ids = (List<Integer>) requestJson.get("checkMenus");
            ids.forEach(id ->{
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setMenuId(id);
                roleMenu.setRoleId(role.getId());
                roleMenuMapper.insertSelective(roleMenu);
            });
            return CommonUtils.successJson("添加成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    @Transactional
    public String deleteRole(JSONObject requestJson) {
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andRoleIdEqualTo(requestJson.getIntValue("id"));
        List<UserRole> userRoles = userRoleMapper.selectByExample(example);
        if (!userRoles.isEmpty()) {
            return CommonUtils.errorJson(ErrorCode.E_10008);
        }
        int i = roleMapper.deleteByPrimaryKey(requestJson.getIntValue("id"));
        if (i > 0) {
            RoleMenuExample roleMenuExample = new RoleMenuExample();
            roleMenuExample.createCriteria().andRoleIdEqualTo(requestJson.getIntValue("id"));
            roleMenuMapper.deleteByExample(roleMenuExample);
            return CommonUtils.successJson("删除成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    public String selectRole(JSONObject requestJson) {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIsNotNull();
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        return CommonUtils.successJson(roleList);
    }

    @Override
    @Transactional
    public String updateRole(JSONObject requestJson) {
        Role role = requestJson.toJavaObject(Role.class);
        int i = roleMapper.updateByPrimaryKeySelective(role);
        if (i > 0) {
            return CommonUtils.successJson("修改成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }
}
