package com.example.springbootjunit.testng.basic.spring;

import com.example.springbootjunit.service.FooService;
import com.example.springbootjunit.testng.basic.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

@ContextConfiguration(classes = Config.class)
public class FooServiceImplConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private FooService foo;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(this.foo.getCount(), 0);

        this.foo.plusCount();
        assertEquals(this.foo.getCount(), 1);
    }

}
