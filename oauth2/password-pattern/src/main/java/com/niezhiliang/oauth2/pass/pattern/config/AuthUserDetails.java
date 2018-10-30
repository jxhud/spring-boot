package com.niezhiliang.oauth2.pass.pattern.config;

import com.niezhiliang.oauth2.pass.pattern.domain.Authority;
import com.niezhiliang.oauth2.pass.pattern.domain.AuthorityExample;
import com.niezhiliang.oauth2.pass.pattern.domain.Credentials;
import com.niezhiliang.oauth2.pass.pattern.domain.CredentialsExample;
import com.niezhiliang.oauth2.pass.pattern.mapper.AuthorityMapper;
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
//        AuthorityExample authorityExample = new AuthorityExample();
//        authorityExample.createCriteria().andIdIsNotNull();
//        Authority authority = authorityMapper.selectByExample(authorityExample).get(0);
        Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        User user = new User(credentials.getName(),credentials.getPassword(),true,true,true,true,authList);

        return  user;
    }
}
