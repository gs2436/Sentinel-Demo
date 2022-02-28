package com.gs.cloudAlibaba.blockHandler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.entity.Result;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomerBlockHandler1 implements BlockExceptionHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        if(e instanceof SystemBlockException) {
            Result<String> result = new Result<String>("系统规则", 500);

            //httpServletResponse.setStatus(500);
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            // spring mvc自带的json操作工具，叫jackson
            new ObjectMapper().writeValue(httpServletResponse.getWriter(), result);
        }

    }

}
