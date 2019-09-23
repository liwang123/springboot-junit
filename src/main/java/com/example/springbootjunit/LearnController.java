package com.example.springbootjunit;

import com.example.springbootjunit.pojo.User;
import com.example.springbootjunit.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/learn")
public class LearnController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/testName")
    public String getModel(String name) {
        return name;
    }


    @GetMapping("/getUser")
    public User getUser(String name) {
        return this.userService.getUser(name);
    }


}