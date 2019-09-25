package com.example.springbootjunit.testng;

import com.example.springbootjunit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.testng.AssertJUnit.assertEquals;

@SpringBootTest
public class TestNg extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Autowired
    private UserService userService;

    @BeforeClass
    public void setupMockMvc() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @AfterClass
    public void testAfterClass() {
        System.out.println("---------AfterClass----------");
    }

    @BeforeTest
    public void testBeforeTest() {
        System.out.println("---------BeforeTest----------");
    }

    @AfterTest
    public void testAfterTest() {
        System.out.println("---------AfterTest----------");
    }


    @BeforeGroups(groups = {"高"})
    public void testBeforeGroups() {
        System.out.println("---------BeforeGroups----------");
    }

    @AfterGroups(groups = {"高"})
    public void testAfterGroups() {
        System.out.println("---------AfterGroups----------");
    }

//    /**
//     * 参数化1
//     *
//     * @return
//     */
//    // 定义对象数组
//    @DataProvider(name = "add")
//    public Object[][] Users() {
//        return new Object[][]{
//                {2, 2, 4},
//                {3, 3, 7},
//        };
//    }
//
//    @Test(dataProvider = "add")
//    public void testAdd2(int add1, int add2, int result) {
//        System.out.println(add1 + "+" + add2 + "=" + result);
//    }
//
//    /**
//     * 参数化2
//     *
//     * @return
//     */
//    @Test
//    @Parameters({"add1", "add2", "result"})
//    public void testAdd1(@Optional("1") int add1, @Optional("1") int add2, @Optional("1") int result) {
//        System.out.println(add1 + " " + add2 + " " + result);
//    }
//
//    // 该条用例跳过执行
//    @Test(enabled = false)
//    public void testCase1() {
//        assertEquals(2 + 2, 4);
//    }
//
//    // 设定用例超时时间
//    @Test(timeOut = 3000)
//    public void testCase2() throws InterruptedException {
//        Thread.sleep(300);
//    }
//
//    // 预设用例抛出的异常类型
//    @Test(expectedExceptions = RuntimeException.class)
//    public void testCase3() {
//        assertEquals(2 / 0, 1);
//    }
//
//    @Test(groups = {"高", "正常"})
//    public void testCase5() {
//        System.out.println(5);
//    }
//
//    @Test(groups = {"高", "正常"})
//    public void testCase6() {
//        System.out.println(6);
//    }
//
//    @Test(groups = {"中", "正常"})
//    public void testCase7() {
//        System.out.println(7);
//    }
//
//
//    @Test(groups = {"低", "异常"})
//    public void testCase8() {
//        System.out.println(8);
//    }
//
//    //依赖测试
//    @Test(dependsOnMethods = {"testCase8"})
//    public void testCase9() {
//        System.out.println(9);
//    }
//
//    /**
//     * 线程池
//     */
//
//    @Test(threadPoolSize = 3, invocationCount = 2, timeOut = 10000)
//    public void testCase10() {
//        System.out.println(10);
//    }
//
//
//    /**
//     * mockMvc.perform执行一个请求
//     * MockMvcRequestBuilders.get(“/user/1”)构造一个请求，Post请求就用.post方法
//     * contentType(MediaType.APPLICATION_JSON_UTF8)代表发送端发送的数据格式是application/json;charset=UTF-8
//     * accept(MediaType.APPLICATION_JSON_UTF8)代表客户端希望接受的数据类型为application/json;charset=UTF-8
//     * session(session)注入一个session，这样拦截器才可以通过
//     * ResultActions.andExpect添加执行完成后的断言
//     * ResultActions.andExpect(MockMvcResultMatchers.status().isOk())方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
//     * andExpect(MockMvcResultMatchers.jsonPath(“$.author”).value(“测试”))这里jsonPath用来获取author字段比对是否为测试,不是就测试不通过
//     * ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
//     *
//     * @throws Exception
//     */
//    @Test
//    public void addLearn() throws Exception {
//        String name = "1";
//        this.mvc.perform(MockMvcRequestBuilders.get("/learn/testName")
//                .accept(MediaType.APPLICATION_JSON_UTF8)
//                .param("name", name)
//        )
//                .andExpect(content().string("1"))
//                .andDo(print());
//    }
}