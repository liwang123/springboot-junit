package com.example.springbootjunit.testng.basic.spring;

import com.example.springbootjunit.service.FooService;
import com.example.springbootjunit.service.FooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@ContextConfiguration(classes = FooServiceImpl.class)
public class UserServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FooService fooService;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(this.fooService.getCount(), 0);
        this.fooService.plusCount();
        assertEquals(this.fooService.getCount(), 1);
    }

}
