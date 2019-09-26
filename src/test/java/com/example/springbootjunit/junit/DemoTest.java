package com.example.springbootjunit.junit;

import com.example.springbootjunit.SpringbootJunitApplicationTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author wang
 * @date 测试套件
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DemoTest1.class, SpringbootJunitApplicationTests.class})
public class DemoTest {

}
