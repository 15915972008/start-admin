package com.start.startcore.base;

/**
 * 基础枚举接口
 *
 * @version 1.0
 * @author huangw 2020-05-31
 */
public interface BaseEnum<K, V> {

    /**
     * 获取编码
     *
     * @return 编码
     */
    K code();

    /**
     * 获取描述
     *
     * @return 描述
     */
    V desc();

}
