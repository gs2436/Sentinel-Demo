package demo.controller;

import demo.entity.Result;
import demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Value("${config.time.sleepMills}")
    private Long sleepMills;

    /**
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<String> getUser(@PathVariable("id") Long id) {
        Result<String> result;
        try {
            //try {
            //    Thread.sleep(2500);
            //    result = new Result<String>("成功", 200);
            //    return result;
            //}
            //catch (InterruptedException e) {
            //    e.printStackTrace();
            //    result = new Result<>("异常", 500);
            //    return result;
            //}

            Thread.sleep(sleepMills);
            result = new Result<String>("成功", 200);
            //int i = 1 / 0;
            return result;
        }
        catch (Exception ex) {
            result = new Result<>("异常", 500);
            return result;
        }
    }

}
