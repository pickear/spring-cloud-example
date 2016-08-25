package com.weasel.springcloud.netflix.eureka.app.controller;

import com.weasel.springcloud.netflix.eureka.app.service.UserService;
import com.weasel.springcloud.netflix.eureka.interfaces.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/info/{username}")
    @ResponseBody
    public User userInfo(Model model,@PathVariable("username") String username){

        User user = service.getUserByUsername(username);
        model.addAttribute("user",user);
        return user;
    }
}
