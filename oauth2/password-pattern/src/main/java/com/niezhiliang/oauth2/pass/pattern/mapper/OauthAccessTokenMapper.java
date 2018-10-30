package com.niezhiliang.oauth2.pass.pattern.mapper;

import com.niezhiliang.oauth2.pass.pattern.domain.OauthAccessToken;
import com.niezhiliang.oauth2.pass.pattern.domain.OauthAccessTokenExample;
import com.niezhiliang.oauth2.pass.pattern.domain.OauthAccessTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthAccessTokenMapper {
    long countByExample(OauthAccessTokenExample example);

    int deleteByExample(OauthAccessTokenExample example);

    int insert(OauthAccessTokenWithBLOBs record);

    int insertSelective(OauthAccessTokenWithBLOBs record);

    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBs(OauthAccessTokenExample example);

    List<OauthAccessToken> selectByExample(OauthAccessTokenExample example);

    int updateByExampleSelective(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExample(@Param("record") OauthAccessToken record, @Param("example") OauthAccessTokenExample example);
}