package com.example.springbootjunit.testng.mock;

import com.example.springbootjunit.biz.Bar;
import com.example.springbootjunit.biz.Foo;
import com.example.springbootjunit.biz.FooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = FooImpl.class)
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class Spring_1_Test extends AbstractTestNGSpringContextTests {

    @MockBean
    private Bar bar;

    @Autowired
    private Foo foo;

    @Test
    public void testCheckCodeDuplicate() throws Exception {

        when(this.bar.getAllCodes()).thenReturn(Collections.singleton("123"));
        assertEquals(this.foo.checkCodeDuplicate("123"), true);

    }

}
