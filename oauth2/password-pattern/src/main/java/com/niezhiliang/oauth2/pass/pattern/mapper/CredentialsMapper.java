package com.niezhiliang.oauth2.pass.pattern.mapper;

import com.niezhiliang.oauth2.pass.pattern.domain.Credentials;
import com.niezhiliang.oauth2.pass.pattern.domain.CredentialsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsMapper {
    long countByExample(CredentialsExample example);

    int deleteByExample(CredentialsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Credentials record);

    int insertSelective(Credentials record);

    List<Credentials> selectByExample(CredentialsExample example);

    Credentials selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Credentials record, @Param("example") CredentialsExample example);

    int updateByExample(@Param("record") Credentials record, @Param("example") CredentialsExample example);

    int updateByPrimaryKeySelective(Credentials record);

    int updateByPrimaryKey(Credentials record);
}