package com.start.startcore.system.controller;

import com.start.startcore.base.Result;
import com.start.startcore.system.dto.User;
import com.start.startcore.system.service.UserService;
import com.start.startcore.util.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户Controller
 *
 * @version 1.0
 * @author huangw 2020-05-30
 */
@Api(tags = "用户管理")
@RequestMapping("/sys/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查找所有用户")
    @GetMapping("/queryAll")
    public Result queryAll(){

        List<User> list = userService.selectAll();
        return Results.successWithData(list);
    }

    @ApiOperation("查找单个用户")
    @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path")
    @GetMapping("/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId){
        User user = userService.get(userId);
        return Results.successWithData(user);
    }

    @ApiOperation("保存用户")
    @PostMapping("/save")
    public Result save(@Valid @RequestBody User user){
        user = userService.insertSelective(user);
        return Results.successWithData(user);
    }

    @ApiOperation("更新用户")
    @PostMapping("/update")
    public Result update(@Valid @RequestBody List<User> user){
        user = userService.persistSelective(user);
        return Results.successWithData(user);
    }


    @ApiOperation("删除单个用户")
    @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path")
    @GetMapping("/delete/{userId}")
    public Result delete(@PathVariable Long userId){
        userService.delete(userId);
        return Results.success();
    }

}