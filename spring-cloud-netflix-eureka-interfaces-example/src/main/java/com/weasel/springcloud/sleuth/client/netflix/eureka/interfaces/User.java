package com.weasel.springcloud.sleuth.client.netflix.eureka.interfaces;

/**
 * @author Dylan
 * @date 2016/8/1.
 */
public class User {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
