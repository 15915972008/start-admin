package com.start.startcore.system.service;


import com.start.startcore.base.Service;
import com.start.startcore.system.dto.User;

import java.util.Set;

/**
 * 用户Service接口
 *
 * @version 1.0
 * @author huangw 2020-05-30
 */
public interface UserService extends Service<User> {
    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);
}
