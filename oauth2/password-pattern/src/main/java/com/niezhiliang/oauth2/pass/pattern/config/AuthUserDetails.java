package com.niezhiliang.oauth2.pass.pattern.config;

import com.niezhiliang.oauth2.pass.pattern.domain.*;
import com.niezhiliang.oauth2.pass.pattern.mapper.AuthorityMapper;
import com.niezhiliang.oauth2.pass.pattern.mapper.CredentialsAuthoritiesMapper;
import com.niezhiliang.oauth2.pass.pattern.mapper.CredentialsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/10/27 上午11:03
 */
@Service
public class AuthUserDetails implements UserDetailsService {
    @Autowired
    private CredentialsMapper credentialsMapper;
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private CredentialsAuthoritiesMapper credentialsAuthoritiesMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CredentialsExample example = new CredentialsExample();
        example.createCriteria().andNameEqualTo(userName);
        Credentials credentials = null;
        try {
            credentials = credentialsMapper.selectByExample(example).get(0);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User"+userName+"can not be found");
        }
        CredentialsAuthoritiesExample credentialsAuthoritiesExample =
                new CredentialsAuthoritiesExample();
        credentialsAuthoritiesExample.createCriteria().andCredentialsIdEqualTo(credentials.getId().longValue());
        List<CredentialsAuthorities> credentialsAuthoritiesList = credentialsAuthoritiesMapper.selectByExample(credentialsAuthoritiesExample);
        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andIdEqualTo(credentialsAuthoritiesList.get(0).getAuthoritiesId().intValue());
        List<Authority> authorityList = authorityMapper.selectByExample(authorityExample);
        Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authorityList.forEach(authority -> {
            ((ArrayList<GrantedAuthority>) authList).add(new SimpleGrantedAuthority(authority.getAuthority()));
        });
        User user = new User(credentials.getName(),credentials.getPassword(),true,true,true,true,authList);

        return  user;
    }
}
