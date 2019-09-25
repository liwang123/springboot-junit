package com.example.springbootjunit.testng.mock;

import com.example.springbootjunit.biz.Bar;
import com.example.springbootjunit.biz.FooImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

public class MockitoTest {

    @Mock
    private Bar bar;

    @InjectMocks
    private FooImpl foo;

    @BeforeMethod(alwaysRun = true)
    public void initMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCheckCodeDuplicate() throws Exception {

        when(this.bar.getAllCodes()).thenReturn(Collections.singleton("123"));
        assertEquals(this.foo.checkCodeDuplicate("123"), true);

    }

}
