package com.start.startcore.system.service.impl;

import com.start.startcore.base.BaseService;
import com.start.startcore.system.controller.UserController;
import com.start.startcore.system.dto.User;
import com.start.startcore.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service实现类
 *
 * @version 1.0
 * @author haungw 2020-05-30
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

}