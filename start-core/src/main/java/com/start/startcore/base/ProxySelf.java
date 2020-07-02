package com.start.startcore.base;

import org.springframework.aop.framework.AopContext;

/**
 * 获取代理对象本身.
 */
public interface ProxySelf<T> {
    /**
     * 取得当前对象的代理.
     *
     * @return 代理对象,如果未被代理,则抛出 IllegalStateException
     */
    @SuppressWarnings("unchecked")
    default T self() {
        return (T) AopContext.currentProxy();
    }
}
