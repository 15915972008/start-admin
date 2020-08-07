package com.start.startsecurity.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

/**
 * 验证码异常
 *
 * @author bojiangzhou 2018/10/06
 */
public class CaptchaException extends InternalAuthenticationServiceException {

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaException(String message) {
        super(message);
    }

}
