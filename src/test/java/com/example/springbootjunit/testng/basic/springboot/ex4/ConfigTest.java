package com.example.springbootjunit.testng.basic.springboot.ex4;

import com.example.springbootjunit.service.FooServiceImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import(FooServiceImpl.class)
public class ConfigTest {
}
