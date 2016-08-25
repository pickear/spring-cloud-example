package com.weasel.springcloud.config.client.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan
 * @date 2016/7/27.
 */
@RestController
@RefreshScope
public class HomeController {

    @Value("${zookeeper.url:zk.url}")
    private String zkUrl;

    @Value("${jdbcUrl:mysql.url}")
    private String mysqlUrl;

    @RequestMapping("hello-zk")
    public String helloZk(){
        return "hello zk : " + zkUrl;
    }

    @RequestMapping("hello-mysql")
    public String helloMysql(){
        return "hello mysql : " + mysqlUrl;
    }
}
