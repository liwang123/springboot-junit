package com.example.springbootjunit.testng.basic.springboot.ex6;

import com.example.springbootjunit.service.FooService;
import com.example.springbootjunit.testng.basic.BasicJunitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FooServiceImplTest extends BasicJunitTest {

    @Autowired
    private FooService foo;

    @Test
    public void testPlusCount() throws Exception {
        assertEquals(this.foo.getCount(), 0);

        this.foo.plusCount();
        assertEquals(this.foo.getCount(), 1);
    }

}
