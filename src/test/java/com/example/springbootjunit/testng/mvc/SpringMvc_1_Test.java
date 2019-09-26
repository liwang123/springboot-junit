package com.example.springbootjunit.testng.mvc;

import com.example.springbootjunit.controller.LearnController;
import com.example.springbootjunit.pojo.User;
import com.example.springbootjunit.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@WebAppConfiguration
@ContextConfiguration(classes = {LearnController.class, UserServiceImpl.class})
public class SpringMvc_1_Test extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @BeforeMethod
    public void prepareMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .alwaysDo(print())//全局配置
                .alwaysExpect(status().isOk())
                .defaultRequest(get("").accept(MediaType.APPLICATION_JSON_UTF8))
                .build();
        this.session = new MockHttpSession();
        User user = new User(1L, "root", 12);
        this.session.setAttribute("user", user);
    }


    @DataProvider(name = "add")
    public Object[][] Users() {
        return new Object[][]{
                {"1"}, {"2"}
        };
    }

    @Test(dataProvider = "add")
    public void testController(String name) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/learn/getUser")
                .param("name", name)
                .session(this.session)
        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("qq"))
        ;

    }

}
