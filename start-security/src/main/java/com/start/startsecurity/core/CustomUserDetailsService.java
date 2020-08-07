package com.start.startsecurity.core;


import com.start.startcore.system.dto.User;
import com.start.startcore.system.service.UserService;
import com.start.startsecurity.dto.GrantedAuthorityImpl;
import com.start.startsecurity.dto.JwtUserDetails;
import com.start.startsecurity.exception.AccountNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 加载用户信息实现类
 *
 * @author huangw 2020/07/12
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws AccountNotExistsException {
        User user = userService.get("userName",username);
        if (user == null) {
            throw new AccountNotExistsException("该用户不存在");
        }
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = userService.findPermissions(username);
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(username, user.getPassword(), grantedAuthorities);
    }


}