package com.niezhiliang.oauth2.pass.pattern.mapper;

import com.niezhiliang.oauth2.pass.pattern.domain.CredentialsAuthorities;
import com.niezhiliang.oauth2.pass.pattern.domain.CredentialsAuthoritiesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CredentialsAuthoritiesMapper {
    long countByExample(CredentialsAuthoritiesExample example);

    int deleteByExample(CredentialsAuthoritiesExample example);

    int insert(CredentialsAuthorities record);

    int insertSelective(CredentialsAuthorities record);

    List<CredentialsAuthorities> selectByExample(CredentialsAuthoritiesExample example);

    int updateByExampleSelective(@Param("record") CredentialsAuthorities record, @Param("example") CredentialsAuthoritiesExample example);

    int updateByExample(@Param("record") CredentialsAuthorities record, @Param("example") CredentialsAuthoritiesExample example);
}