package com.example.springbootjunit.testng.basic.springboot.ex2;

import com.example.springbootjunit.service.FooService;
import com.example.springbootjunit.service.FooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class FooServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FooService foo;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(this.foo.getCount(), 0);

        this.foo.plusCount();
        assertEquals(this.foo.getCount(), 1);
    }

    @Configuration
    @Import(FooServiceImpl.class)
    static class ConfigTest {
    }

}
