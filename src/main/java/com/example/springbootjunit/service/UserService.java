package com.example.springbootjunit.service;

import com.example.springbootjunit.pojo.User;

/**
 * @author wang
 * @date 2019/9/23 11:48
 */
public interface UserService {
    User getUser(String name);
}
