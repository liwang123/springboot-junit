package com.example.springbootjunit.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author wang
 * @date 参数化测试
 */
@RunWith(Parameterized.class)
public class ParamtersTest {
    @Parameterized.Parameters(name = "{index}: fib({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {6, 8}
        });
    }

    private final int input;
    private final int expected;

    public ParamtersTest(final int input, final int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(this.expected, this.compute(this.input));
    }

    public static int compute(final int n) {
        int result = 0;

        if (n <= 1) {
            result = n;
        } else {
            result = compute(n - 1) + compute(n - 2);
        }

        return result;
    }

    @Test
    public void testPop(){
        System.out.println(-123/10);
    }

}