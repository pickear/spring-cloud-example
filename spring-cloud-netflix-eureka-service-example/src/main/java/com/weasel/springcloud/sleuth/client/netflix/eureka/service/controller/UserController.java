package com.weasel.springcloud.sleuth.client.netflix.eureka.service.controller;

import com.weasel.springcloud.sleuth.client.netflix.eureka.interfaces.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/get/{username}")
    @ResponseBody
    public User get(@PathVariable("username") String username){

        User user = new User();
        user.setUsername(username);
        user.setPassword("124");
        return user;
    }
}
