package com.weasel.springcloud.sleuth.client.zookeeper.server.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan
 * @date 2016/7/21.
 */
@RestController
public class HomeController {

    @RequestMapping("/hello")
    public String home(){

        return "hello world";
    }
}
