package com.start.startsecurity.core;

import com.start.startsecurity.exception.PasswordErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * 身份验证提供者
 * @author Louis
 * @date Jun 29, 2019
 */
public class JwtAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
        setUserDetailsService(userDetailsService);
        setPasswordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	// 可以在此处覆写整个登录认证逻辑
    	return super.authenticate(authentication);
    }
    
    @Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
        String password = userDetails.getPassword();
        String loginPassWord = authentication.getCredentials().toString();
        //不知道为什么死活注入为空
//        boolean match = passwordEncoder.matches(loginPassWord, password);
        boolean match = password.equals(loginPassWord);
        if (!match) {
            throw new PasswordErrorException("user.error.login.username-or-password.error");
        }
        // 可以在此处覆写密码验证逻辑
//		super.additionalAuthenticationChecks(userDetails, authentication);
	}

}