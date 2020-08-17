package com.start.startsecurity.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.start.startcore.base.Result;
import com.start.startcore.constants.BaseEnums;
import com.start.startcore.util.Results;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * HTTP工具类
 * @author Louis
 * @date Jun 29, 2019
 */
public class HttpUtils {

    /**
     * 获取HttpServletRequest对象
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 输出信息到浏览器
     * @param response
     * @param
     * @throws IOException
     */
    public static void writeSuccessful(HttpServletResponse response, Object data) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        Result result = Results.successWithData(data, null,BaseEnums.SUCCESS.desc());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }

    public static void writeUnSuccessful(HttpServletResponse response, Object data) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        Result result = Results.failureWithData(data, null,BaseEnums.ERROR.desc());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }

}

