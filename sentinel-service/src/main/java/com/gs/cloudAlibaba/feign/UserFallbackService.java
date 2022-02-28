package com.gs.cloudAlibaba.feign;

import demo.entity.Result;
import demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService {

    @Override
    public Result<String> getUser(Long id) {
        Result<String> result = new Result<String>("降级", 500);
        return result;
    }

    @Override
    public String getUser1(Long id) {
        return "降级";
    }

}
