package com.niezhiliang.oauth2.pass.pattern.mapper;

import com.niezhiliang.oauth2.pass.pattern.domain.OauthClientDetails;
import com.niezhiliang.oauth2.pass.pattern.domain.OauthClientDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientDetailsMapper {
    long countByExample(OauthClientDetailsExample example);

    int deleteByExample(OauthClientDetailsExample example);

    int insert(OauthClientDetails record);

    int insertSelective(OauthClientDetails record);

    List<OauthClientDetails> selectByExample(OauthClientDetailsExample example);

    int updateByExampleSelective(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);

    int updateByExample(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);
}