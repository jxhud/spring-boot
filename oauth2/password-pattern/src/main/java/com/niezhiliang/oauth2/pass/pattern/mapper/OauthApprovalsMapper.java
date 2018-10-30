package com.niezhiliang.oauth2.pass.pattern.mapper;

import com.niezhiliang.oauth2.pass.pattern.domain.OauthApprovals;
import com.niezhiliang.oauth2.pass.pattern.domain.OauthApprovalsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthApprovalsMapper {
    long countByExample(OauthApprovalsExample example);

    int deleteByExample(OauthApprovalsExample example);

    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);

    List<OauthApprovals> selectByExample(OauthApprovalsExample example);

    int updateByExampleSelective(@Param("record") OauthApprovals record, @Param("example") OauthApprovalsExample example);

    int updateByExample(@Param("record") OauthApprovals record, @Param("example") OauthApprovalsExample example);
}