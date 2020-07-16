package com.start.startsecurity.core;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 * @author Louis
 * @date Jun 29, 2019
 */
@RestController
public class LoginController {
    //自定义认证
    //定义登录接口实现，只要在登录接口手动触发登录流程并生产令牌即可。
    //Spring Security 的登录认证过程只需调用 AuthenticationManager 的 authenticate(Authentication authentication) 方法，
    // 最终返回认证成功的 Authentication 实现类并存储到SpringContexHolder 上下文即可，这样后面授权的时候就可以从
    // SpringContexHolder 中获取登录认证信息，并根据其中的用户信息和权限信息决定是否进行授权

    //注意：如果使用此登录控制器触发登录认证，需要禁用登录认证过滤器，即将 WebSecurityConfig 中的以下配置项注释即可，
    // 否则访问登录接口会被过滤拦截，执行不会再进入此登录接口，大家根据使用习惯二选一即可。
    //http.addFilterBefore(new JwtLoginFilter(authenticationManager()), UsernamePasswordAuthenticationFilter .class);

//    如下是登录认证的逻辑， 可以看到部分逻辑跟上面的登录认证过滤器差不多。
//
//            1. 执行登录认证过程，通过调用 AuthenticationManager 的 authenticate(token) 方法实现
//
//2. 将认证成功的认证信息存储到上下文，供后续访问授权的时候获取使用
//
//3. 通过JWT生成令牌并返回给客户端，后续访问和操作都需要携带此令牌
//
//    有关登录过程的逻辑，参见SecurityUtils的login方法

//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    /**
//     * 登录接口
//     */
//    @PostMapping(value = "/login")
//    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
//        String username = loginBean.getUsername();
//        String password = loginBean.getPassword();
//
//        // 系统登录认证
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
//
//        return HttpResult.ok(token);
//    }

}
