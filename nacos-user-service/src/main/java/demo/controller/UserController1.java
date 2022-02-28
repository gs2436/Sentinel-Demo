package demo.controller;

import demo.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user1")
public class UserController1 {

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Long id) {
        return "成功";
    }

}
