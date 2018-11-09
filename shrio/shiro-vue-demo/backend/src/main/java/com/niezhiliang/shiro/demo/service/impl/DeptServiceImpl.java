package com.niezhiliang.shiro.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.constant.ErrorCode;
import com.niezhiliang.shiro.demo.domain.Dept;
import com.niezhiliang.shiro.demo.domain.DeptExample;
import com.niezhiliang.shiro.demo.mapper.DeptMapper;
import com.niezhiliang.shiro.demo.service.DeptService;
import com.niezhiliang.shiro.demo.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午3:45
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    @Transactional
    public String addDept(JSONObject requestJson) {
        Dept dept = requestJson.toJavaObject(Dept.class);
        dept.setCreateTime(new Date());
        int i = deptMapper.insertSelective(dept);
        if (i > 0) {
            return CommonUtils.successJson("添加成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    @Transactional
    public String deleteDept(JSONObject requestJson) {
        int deptId = requestJson.getIntValue("id");
        int i = deptMapper.deleteByPrimaryKey(deptId);
        if (i > 0) {
            return CommonUtils.successJson("删除成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }

    @Override
    public String selectDept(JSONObject requestJson) {
        DeptExample example = new DeptExample();
        example.createCriteria().andIdIsNotNull();
        List<Dept> depts = deptMapper.selectByExample(example);

        return CommonUtils.successJson(depts);
    }

    @Override
    @Transactional
    public String updateDept(JSONObject requestJson) {
        Dept dept = requestJson.toJavaObject(Dept.class);
        int i = deptMapper.updateByPrimaryKeySelective(dept);
        if (i > 0) {
            return CommonUtils.successJson("修改成功");
        }
        return CommonUtils.errorJson(ErrorCode.E_400);
    }
}
