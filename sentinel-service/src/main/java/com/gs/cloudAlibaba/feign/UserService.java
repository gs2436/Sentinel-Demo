package com.gs.cloudAlibaba.feign;

import demo.entity.Result;
import demo.entity.User;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 服务方超时或发生未捕获的异常，执行fallback
 */
@FeignClient(value = "nacos-user-service",
        configuration = {UserService.ProviderFeignClientConfigure.class},
        fallback = UserFallbackService.class)
public interface UserService {

    @GetMapping("/user/{id}")
    Result<String> getUser(@PathVariable("id") Long id);

    @GetMapping("/user1/{id}")
    String getUser1(@PathVariable("id") Long id);

    class ProviderFeignClientConfigure{
        //设置超时时间
        @Bean
        Request.Options options(){
            return new Request.Options(3000, 3000);
        }
    }

}
