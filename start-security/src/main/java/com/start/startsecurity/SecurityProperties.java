package com.start.startsecurity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Security 配置
 *
 * @author bojiangzhou 2018/03/28
 */
@ConfigurationProperties(prefix = SecurityProperties.PREFIX)
public class SecurityProperties {

    public static final String PREFIX = "sunny.security";

    /**
     * 登录页面
     */
    private String loginPage = "/login";


    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

}
