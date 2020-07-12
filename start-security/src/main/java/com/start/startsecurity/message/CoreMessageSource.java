package com.start.startsecurity.message;

import com.lyyzoo.sunny.core.helper.LanguageHelper;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * default MessageSource for sunny-starter-core.
 *
 * @author bojiangzhou 2018/09/04
 */
public class CoreMessageSource {

    private CoreMessageSource() {}

    private static final MessageSource messageSource;

    static {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasename("com.lyyzoo.sunny.core.messages");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setUseCodeAsDefaultMessage(true);
        messageSource = bundleMessageSource;
    }

    /**
     * @param code code
     * @return message
     */
    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, code, LanguageHelper.locale());
    }

    /**
     * @param code code
     * @param args args
     * @return message
     */
    public static String getMessage(String code, Object ... args) {
        return messageSource.getMessage(code, args, code, LanguageHelper.locale());
    }

}
