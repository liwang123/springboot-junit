package com.example.springbootjunit.testng.mvc;

import com.example.springbootjunit.biz.Foo;
import com.example.springbootjunit.controller.FooController;
import com.example.springbootjunit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = {FooController.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class BootMvc_Test extends AbstractTestNGSpringContextTests {

    private MockMvc mvc;

    @MockBean
    private Foo foo;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockHttpSession session;

    @BeforeMethod
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .alwaysDo(print())//全局配置
                .alwaysExpect(status().isOk())
                .defaultRequest(get("").accept(MediaType.APPLICATION_JSON_UTF8))
                .build();
        this.session = new MockHttpSession();
        User user = new User(1L, "root", 12);
        this.session.setAttribute("user", user);
    }

    @Test
    public void testController() throws Exception {

        when(this.foo.checkCodeDuplicate(anyString())).thenReturn(true);

        this.mvc.perform(get("/foo/check-code-dup").param("code", "123"))
                .andExpect(content().string("true"));

    }

}
