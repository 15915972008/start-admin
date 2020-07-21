package com.start.startcore.util;


import com.start.startcore.base.Result;
import org.springframework.http.HttpStatus;

/**
 * Result生成工具类
 *
 * @version 1.0
 * * @author huangw 2020-05-27
 */
public class Results {
    protected Results() {}

    public static Result newResult() {
        return new Result();

    }

    public static Result newResult(boolean success) {
        return new Result(success);
    }

    //
    // 业务调用成功
    // ----------------------------------------------------------------------------------------------------
    public static Result success() {
        return new Result();
    }

    public static Result success(String msg) {
        return new Result(true, null, msg);
    }

    public static Result success(String code, String msg) {
        return new Result(true, code, msg);
    }

    public static Result successWithStatus(Integer status) {
        return new Result(true, status);
    }

    public static Result successWithStatus(Integer status, String msg) {
        return new Result(true, status, null, msg);
    }

    public static Result successWithData(Object data) {
        return new Result(true, null, null,null, data);
    }

    public static Result successWithData(Object data, String msg) {
        return new Result(true, null,null, msg, data);
    }

    public static Result successWithData(Object data,String code, String msg) {
        return new Result(true, HttpStatus.OK.value(), code, msg, data);
    }

    //
    // 业务调用失败
    // ----------------------------------------------------------------------------------------------------
    public static Result failure() {
        return new Result(false,HttpStatus.valueOf("500").value());
    }

    public static Result failure(String msg) {
        return new Result(false, HttpStatus.valueOf("500").value(),null, msg);
    }

    public static Result failure(String code, String msg) {
        return new Result(false, HttpStatus.valueOf("500").value(),code, msg);
    }

    public static Result failureWithStatus(Integer status) {
        return new Result(false, status);
    }

    public static Result failureWithStatus(Integer status, String msg) {
        return new Result(false, status, null, msg);
    }

    public static Result failureWithData(Object data) {
        return new Result(false, HttpStatus.valueOf("500").value(), null, null, data);
    }

    public static Result failureWithData(Object data, String msg) {
        return new Result(false, HttpStatus.valueOf("500").value(),null, msg, data);
    }

    public static Result failureWithData(Object data, String code, String msg) {
        return new Result(false, HttpStatus.valueOf("500").value(),code, msg, data);
    }
}
