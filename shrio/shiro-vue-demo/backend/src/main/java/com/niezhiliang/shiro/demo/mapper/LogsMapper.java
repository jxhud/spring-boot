package com.niezhiliang.shiro.demo.mapper;

import com.niezhiliang.shiro.demo.domain.Logs;
import com.niezhiliang.shiro.demo.domain.LogsExample;
import com.niezhiliang.shiro.demo.domain.LogsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogsMapper {
    long countByExample(LogsExample example);

    int deleteByExample(LogsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogsWithBLOBs record);

    int insertSelective(LogsWithBLOBs record);

    List<LogsWithBLOBs> selectByExampleWithBLOBs(LogsExample example);

    List<Logs> selectByExample(LogsExample example);

    LogsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogsWithBLOBs record, @Param("example") LogsExample example);

    int updateByExampleWithBLOBs(@Param("record") LogsWithBLOBs record, @Param("example") LogsExample example);

    int updateByExample(@Param("record") Logs record, @Param("example") LogsExample example);

    int updateByPrimaryKeySelective(LogsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogsWithBLOBs record);

    int updateByPrimaryKey(Logs record);
}