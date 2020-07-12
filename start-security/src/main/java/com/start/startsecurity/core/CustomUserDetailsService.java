package com.start.startsecurity.core;

import java.util.ArrayList;
import java.util.Collection;
import com.start.startsecurity.dto.CustomUserDetails;
import com.start.startsecurity.dto.User;
import com.start.startsecurity.exception.AccountNotExistsException;
import com.start.startsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.get("user_name", username);
        if (user == null) {
            throw new AccountNotExistsException("login.username-or-password.error");
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new CustomUserDetails(username, user.getPassword(), user.getId(),
                user.getNickName(), "暂无", authorities);
    }

}