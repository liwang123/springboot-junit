package com.example.springbootjunit.service;

import com.example.springbootjunit.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author wang
 * @date
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(final String name) {
        if ("1".equals(name)) {
            return User.builder()
                    .age(18)
                    .name("qq").build();
        }
        if ("2".equals(name)) {
            return User.builder()
                    .age(19)
                    .name("ww").build();
        }
        return null;
    }
}
