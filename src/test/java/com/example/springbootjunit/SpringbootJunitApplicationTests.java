package com.example.springbootjunit;

import com.alibaba.fastjson.JSON;
import com.example.springbootjunit.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 */
@RunWith(SpringRunner.class)
//webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//事务回滚
@Rollback
//指定配置文件
@ActiveProfiles("test")
public class SpringbootJunitApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .alwaysDo(print())//全局配置
                .alwaysExpect(status().isOk())
                .defaultRequest(get("").accept(MediaType.APPLICATION_JSON_UTF8))
                .build();
        this.session = new MockHttpSession();
        User user = new User(1L, "root", 12);
        this.session.setAttribute("user", user);
    }

    /**
     * mockMvc.perform执行一个请求
     * MockMvcRequestBuilders.get(“/user/1”)构造一个请求，Post请求就用.post方法
     * contentType(MediaType.APPLICATION_JSON_UTF8)代表发送端发送的数据格式是application/json;charset=UTF-8
     * accept(MediaType.APPLICATION_JSON_UTF8)代表客户端希望接受的数据类型为application/json;charset=UTF-8
     * session(session)注入一个session，这样拦截器才可以通过
     * ResultActions.andExpect添加执行完成后的断言
     * ResultActions.andExpect(MockMvcResultMatchers.status().isOk())方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
     * andExpect(MockMvcResultMatchers.jsonPath(“$.name”).value(“测试”))这里jsonPath用来获取name字段比对是否为测试,不是就测试不通过
     * ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
     *
     * @throws Exception
     */
    @Test
    @Repeat(2)
    public void getUser() throws Exception {
        String name = "1";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/learn/getUser")
                .param("name", name)
                .session(this.session)
        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("qq"))
        ;
    }


    @Test
    public void addLearn() throws Exception {
        String name = "1";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/learn/testName")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("name", name)
        )
                .andExpect(content().string("1"))
                .andDo(print());
    }


    /**
     * Method: addUser(@RequestBody User user)
     */
    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("jamie");
        user.setAge(20);
        this.mockMvc.perform(post("/add").contentType(APPLICATION_JSON).content(JSON.toJSONString(user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();

    }


    @After
    public void test() {
        System.out.println("--------------Runing End-------------");
    }

}
