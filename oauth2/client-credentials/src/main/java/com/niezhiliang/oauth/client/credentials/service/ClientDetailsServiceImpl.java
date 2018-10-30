package com.niezhiliang.oauth.client.credentials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/29 下午4:54
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Autowired
    private DataSource dataSource;
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        JdbcClientDetailsService jdbcClientDetailsService= new JdbcClientDetailsService(dataSource);
        ClientDetails clientDetails = jdbcClientDetailsService.loadClientByClientId(clientId);
        return clientDetails;
    }
}
