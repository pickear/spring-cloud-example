package com.weasel.springcloud.netflix.eureka.app.service.impl;

import com.weasel.springcloud.netflix.eureka.app.service.UserService;
import com.weasel.springcloud.netflix.eureka.interfaces.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RestTemplate restTemplate;

    private final String SERVICE_NAME = "springcloud-netflix-eureka-service";

    @Override
    public User getUserByUsername(String username) {
        return restTemplate.getForObject("http://"+SERVICE_NAME+"/user/get/"+username,User.class);
    }
}
