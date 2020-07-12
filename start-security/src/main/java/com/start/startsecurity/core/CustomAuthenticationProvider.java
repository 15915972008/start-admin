package com.start.startsecurity.core;

import com.start.startsecurity.dto.User;
import com.start.startsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

    /**
     * 自定义认证器
     *
     * @author bojiangzhou 2018/09/09
     */
    @Component
    public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

        @Autowired
        private UserService userService;

        @Autowired
        private CustomUserDetailsService detailsService;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
            // 如有其它逻辑处理，可在此处进行逻辑处理...
            return detailsService.loadUserByUsername(username);
        }

        @Override
        protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
            String username = userDetails.getUsername();
            User user = userService.get("user_name",username);

            // 检查密码是否正确
            String password = userDetails.getPassword();
            String rawPassword = authentication.getCredentials().toString();

            boolean match = passwordEncoder.matches(rawPassword, password);
            if (!match) {
                throw new BadCredentialsException("login.username-or-password.error");
            }
        }
    }
