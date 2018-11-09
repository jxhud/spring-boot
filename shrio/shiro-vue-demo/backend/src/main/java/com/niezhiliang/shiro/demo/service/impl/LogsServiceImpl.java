package com.niezhiliang.shiro.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.domain.LogsWithBLOBs;
import com.niezhiliang.shiro.demo.mapper.LogsMapper;
import com.niezhiliang.shiro.demo.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午4:28
 */
@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private LogsMapper logsMapper;

    @Override
    @Transactional
    public void addLog(LogsWithBLOBs logs) {
        logsMapper.insertSelective(logs);
    }

    @Override
    public List<JSONObject> queryLogs(JSONObject requestJson) {
        return null;
    }
}
