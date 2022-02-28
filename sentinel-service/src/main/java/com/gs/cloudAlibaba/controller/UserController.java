package com.gs.cloudAlibaba.controller;

import com.alibaba.cloud.sentinel.datasource.config.DataSourcePropertiesConfiguration;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.gs.cloudAlibaba.blockHandler.CustomBlockHandler;
import com.gs.cloudAlibaba.feign.UserService;
import demo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${name.extension}")
    private String extension;

    @Autowired
    private UserService userService;

    //spring-cloud-starter-alibaba-sentinel有版本限制(2.2.0不能)，高版本的流控规则，才能根据多级url
    @RequestMapping("byUrl")
    //流控规则：推荐根据value，不要根据url(异常无法捕获)
    @SentinelResource(value = "byUrl",  blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException")
    public Result<String> getUser(@RequestParam(defaultValue = "-1") int id, String name) throws InterruptedException {
        System.out.println("id：" + id + ",name：" + name);
        Result<String> result;
        //Result<String> result = userService.getUser(id);
        result = new Result<String>("成功", 200);
        return result;
    }

    @RequestMapping("/byResource")
    @SentinelResource(value = "byResource")
    public Result<String> byResource(@PathVariable(required = false) Long id) {
        Result<String> result;
        result = new Result<String>("byResource", 200);
        return result;
    }

    public Result<String> handleException(BlockException exception) {
        Result<String> result = new Result<String>("限流1", 500);
        return result;
    }

}
