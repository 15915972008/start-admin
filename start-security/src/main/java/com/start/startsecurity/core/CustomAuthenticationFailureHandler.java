package com.start.startsecurity.core;

import com.start.startsecurity.SecurityProperties;
import com.start.startsecurity.message.MessageAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录失败处理器
 *
 * @author bojiangzhou 2018/03/29
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private SecurityProperties securityProperties;


    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.setAttribute("username", username);
            session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
                    MessageAccessor.getMessage(exception.getMessage(), exception.getMessage()));
        }
        if (exception instanceof BadCredentialsException) {
//            User user = userService.get("user_name",username);
            //登录失败，记录失败次数
            //userService.loginFail(user.getId());
        }

        redirectStrategy.sendRedirect(request, response, securityProperties.getLoginPage() + "?username=" + username);
    }
}
