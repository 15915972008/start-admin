package com.start.startsecurity.entity;

import java.util.Date;
import java.util.Optional;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统用户
 *
 * @author bojiangzhou 2018/09/04
 */
@Table(name = "sys_user")
public class User {

    public static final String FIELD_USERNAME = "username";
    public static final String FIELD_MOBILE = "mobile";
    public static final String FIELD_ENABLED = "enabled";
    public static final String FIELD_DISABLED_DATE = "disabledDate";
    public static final String FIELD_PASSWORD_ERROR_TIME = "passwordErrorTime";

    /**
     * 记录登录错误次数
     */
    public void loginFail() {
        this.passwordErrorTime = Optional.ofNullable(passwordErrorTime).orElse(0) + 1;
    }

    /**
     * 清除登录错误次数
     */
    public void loginSuccess() {
        this.passwordErrorTime = 0;
    }

    /**
     * 主键ID
     */
    @Id
    protected Long userId;

    /**
     * 用户名 登录账号(唯一)，不能是全数字，否则可能与手机号重合
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称 真实姓名
     */
    private String nickname;
    /**
     * 手机号(唯一)
     */
    private String mobile;
    /**
     * 邮箱(唯一)
     */
    private String email;
    /**
     * 语言
     */
    private String language;
    /**
     * 是否启用
     */
    private boolean enabled;
    /**
     * 禁用日期
     */
    private Date disabledDate;
    /**
     * 头像地址
     */
    private String photoUrl;
    /**
     * 密码错误次数
     */
    private Integer passwordErrorTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getDisabledDate() {
        return disabledDate;
    }

    public void setDisabledDate(Date disabledDate) {
        this.disabledDate = disabledDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Integer getPasswordErrorTime() {
        return passwordErrorTime;
    }

    public void setPasswordErrorTime(Integer passwordErrorTime) {
        this.passwordErrorTime = passwordErrorTime;
    }

}
