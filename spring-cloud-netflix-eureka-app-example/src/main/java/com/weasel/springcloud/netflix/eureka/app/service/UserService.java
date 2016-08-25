package com.weasel.springcloud.netflix.eureka.app.service;

import com.weasel.springcloud.netflix.eureka.interfaces.User;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
public interface UserService {

    User getUserByUsername(String username);

}
