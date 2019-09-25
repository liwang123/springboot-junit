package com.example.springbootjunit.junit;

import com.example.springbootjunit.pojo.User;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AssertTest {

    /**
     * 期望值与结果是否相等
     */
    @Test
    public void testassert() {
        assertEquals(1, 1);
        //增量范围相等即为true
        assertEquals(1, 3, 2);
    }

    /**
     * 结果为true
     */
    @Test
    public void testAssertTrue() {
        assertTrue("1", true);
    }

    /**
     * 结果为false
     * 基于assertTrue
     */
    @Test
    public void testAssertFalse() {
        assertFalse("1", false);
    }

    /**
     * 对象不为空
     */
    @Test
    public void testAssertNotNull() {
        assertNotNull("is null", "");
    }

    /**
     * 两个对象是否一个
     */
    @Test
    public void testAssertSame() {
        User user = User.builder().build();
        assertSame(user, user);
    }

    @Test
    public void testAssertThat() {
        Assert.assertThat(1, is(1));
        Assert.assertTrue(anything().matches(3));

    }
}
