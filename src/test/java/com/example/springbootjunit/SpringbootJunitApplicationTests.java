package com.example.springbootjunit;

import controller.LearnController;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJunitApplicationTests {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testEmployee() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/learn/test")).andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse());
    }


    @Test
    @Repeat(3)
    public void contextLoads() {
        System.out.println(1);
    }


    @Before //初始化方法 每次执行 test 都会执行 before 和 after
    public void beforeMethod() {
        System.out.println("junit demo success  --> beforeMethod !");
    }

    @After  //释放资源
    public void afterMethod() {
        System.out.println("junit demo success  --> afterMethod !");
    }

    @BeforeClass  //针对所有测试，只执行一次，且必须为static void
    public static void beforeClassMethod() {
        System.out.println("junit demo success  --> beforeClassMethod !");
    }

    @AfterClass  //针对所有测试，只执行一次，且必须为static void
    public static void afterClassMethod() {
        System.out.println("junit demo success  --> afterClassMethod !");
    }

    @Ignore //忽略的测试方法
    public static void ignoreMethod() {
        System.out.println("junit demo success  --> ignoreMethod !");
    }


}
