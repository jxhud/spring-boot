package com.niezhiliang.shiro.demo.shiro;

import com.niezhiliang.shiro.demo.constant.UserStatus;
import com.niezhiliang.shiro.demo.domain.Menu;
import com.niezhiliang.shiro.demo.domain.Role;
import com.niezhiliang.shiro.demo.domain.User;
import com.niezhiliang.shiro.demo.service.LoginService;
import com.niezhiliang.shiro.demo.service.MenuService;
import com.niezhiliang.shiro.demo.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2018/11/8 上午11:20
 */
public class UserRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        List<Role> roleList = roleService.getUserRoleByUserId(user.getUserId());
        Set<String> roleSet = roleList.stream().map(Role::getRoleName).collect(Collectors.toSet());
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        if (!roleList.isEmpty()) {
            List<Menu> permissionList = menuService.getMenuByRoleId(roleList.get(0).getId());
            Set<String> permissionSet = permissionList.stream().map(Menu::getPermissions).collect(Collectors.toSet());
            simpleAuthorizationInfo.setStringPermissions(permissionSet);
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        String loginName = (String) authcToken.getPrincipal();
        String password = new String((char[]) authcToken.getCredentials());
        User user = loginService.getUserByUserName(loginName);
        if (user == null) {
            //没找到账号
            throw new UnknownAccountException("账号未注册");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password,user.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getEnable() == UserStatus.USER_STATUS_UNABLE.getValue()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        user.setPassword(null);
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
