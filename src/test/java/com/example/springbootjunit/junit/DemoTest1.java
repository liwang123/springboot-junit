package com.example.springbootjunit.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest1 {

    @Test
    @Repeat(3)
    public void contextLoads() {
        System.out.println(1);
    }

    /**
     * 超时
     *
     * @throws InterruptedException
     */
    @Test(timeout = 100)
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(200);
        System.out.println(1);
    }

    /**
     * 预期异常
     */
    @Test(expected = NullPointerException.class)
    public void testException() {
        throw new NullPointerException();
        // System.out.println(2 / 0);
    }


    @Before //初始化方法 每次执行 test 都会执行 before 和 after
    public void beforeMethod() {
        System.out.println("DemoTest1 demo success  --> beforeMethod !");
    }

    @After  //释放资源
    public void afterMethod() {
        System.out.println("DemoTest1 demo success  --> afterMethod !");
    }

    @BeforeClass  //针对所有测试，只执行一次，且必须为static void
    public static void beforeClassMethod() {
        System.out.println("DemoTest1 demo success  --> beforeClassMethod !");
    }

    @AfterClass  //针对所有测试，只执行一次，且必须为static void
    public static void afterClassMethod() {
        System.out.println("DemoTest1 demo success  --> afterClassMethod !");
    }

    @Ignore //忽略的测试方法
    public static void ignoreMethod() {
        System.out.println("DemoTest1 demo success  --> ignoreMethod git remote add origin!");
    }
}
