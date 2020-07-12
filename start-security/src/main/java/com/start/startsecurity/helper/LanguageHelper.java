package com.start.startsecurity.helper;

import java.util.Locale;

import com.start.startsecurity.dto.CustomUserDetails;
import org.apache.commons.lang3.LocaleUtils;
import org.springframework.context.i18n.LocaleContextHolder;

public class LanguageHelper {

    private LanguageHelper() {}

    /**
     * 根据当前登陆用户获取语言信息
     *
     * @return String
     */
    public static String language() {
        CustomUserDetails details = DetailsHelper.getUserDetails();
        if (details != null) {
            return details.getLanguage();
        } else {
            return LocaleContextHolder.getLocale().getLanguage();
        }
    }

    /**
     * 根据当前登陆用户获取 Locale
     *
     * @return Locale
     */
    public static Locale locale() {
        CustomUserDetails details = DetailsHelper.getUserDetails();
        if (details != null) {
            return LocaleUtils.toLocale(details.getLanguage());
        } else {
            return LocaleContextHolder.getLocale();
        }
    }


}
