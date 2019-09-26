package com.example.springbootjunit.testng.basic.springboot.ex3;

import com.example.springbootjunit.service.FooServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FooServiceImpl.class)
public class ConfigTest {
}
