package com.niezhiliang.oauth.client.credentials.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/29 下午8:03
 * 资源服务器
 */
@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    //定义资源服务器的id
    private static final String DEMO_RESOURCE_ID = "index";

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/hello").anonymous()
                //配置order访问控制，必须认证过后才可以访问
                .antMatchers("/**").authenticated();


    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
    }
}
