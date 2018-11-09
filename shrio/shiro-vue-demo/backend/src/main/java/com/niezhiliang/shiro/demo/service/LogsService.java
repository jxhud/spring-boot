package com.niezhiliang.shiro.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.niezhiliang.shiro.demo.domain.LogsWithBLOBs;

import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 下午4:27
 */
public interface LogsService {

    void addLog(LogsWithBLOBs logs);

    List<JSONObject> queryLogs(JSONObject requestJson);

}
