package com.example.springbootjunit.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

/**
 * @author wang
 * @date 参数化测试
 */
@RunWith(Parameterized.class)
public class ParamtersTest {
    private int input;
    private int expected;

    public ParamtersTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {2, 2},
                {6, 6},
                {19, 19}
        });
    }


    @Test
    public void test() {
        assertEquals(this.expected, this.input);
        Assert.assertThat(this.input, is(this.expected));
    }

}