package com.example.springbootjunit.testng.basic;

import com.example.springbootjunit.controller.LearnController;
import com.example.springbootjunit.service.FooServiceImpl;
import com.example.springbootjunit.service.UserServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({LearnController.class, UserServiceImpl.class, FooServiceImpl.class})
public class Config {
}
