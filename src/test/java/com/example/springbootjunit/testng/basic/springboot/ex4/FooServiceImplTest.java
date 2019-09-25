package com.example.springbootjunit.testng.basic.springboot.ex4;

import com.example.springbootjunit.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

}
