package com.niezhiliang.oauth2.pass.pattern.mapper;

import com.niezhiliang.oauth2.pass.pattern.domain.OauthClientToken;
import com.niezhiliang.oauth2.pass.pattern.domain.OauthClientTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthClientTokenMapper {
    long countByExample(OauthClientTokenExample example);

    int deleteByExample(OauthClientTokenExample example);

    int insert(OauthClientToken record);

    int insertSelective(OauthClientToken record);

    List<OauthClientToken> selectByExampleWithBLOBs(OauthClientTokenExample example);

    List<OauthClientToken> selectByExample(OauthClientTokenExample example);

    int updateByExampleSelective(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenExample example);

    int updateByExample(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenExample example);
}