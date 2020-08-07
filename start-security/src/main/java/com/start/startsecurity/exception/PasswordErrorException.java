package com.start.startsecurity.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

/**
 * 密码错误异常
 *
 * @author bojiangzhou 2018/10/06
 */
public class PasswordErrorException extends InternalAuthenticationServiceException {

    public PasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordErrorException(String message) {
        super(message);
    }

}
