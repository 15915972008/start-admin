package com.start.startcore.base;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;

/**
 * BaseMapper
 *
 * @author huangw 2020-05-30
 * @version 1.0
 * @name BaseMapper
 */
public interface Mapper<T> extends BaseMapper<T>, ConditionMapper<T>, IdsMapper<T>, InsertListMapper<T> {

}
