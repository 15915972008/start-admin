package com.start.startsecurity.controller;

import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户Controller
 *
 * @version 1.0
 * @author huangw 2020-05-30
 */
@RequestMapping("/test")
@RestController
public class UserController  {


    @GetMapping("/")
    public String queryAll(){
        return "hello ";
    }



}