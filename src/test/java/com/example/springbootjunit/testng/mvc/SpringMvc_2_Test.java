package com.example.springbootjunit.testng.mvc;

import com.example.springbootjunit.biz.Foo;
import com.example.springbootjunit.controller.FooController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@EnableWebMvc
@WebAppConfiguration
@ContextConfiguration(classes = {FooController.class})
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
@ActiveProfiles("dev")
public class SpringMvc_2_Test extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private Foo foo;

    private MockMvc mvc;

    @BeforeMethod
    public void prepareMockMvc() {
        this.mvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testController() throws Exception {

        when(this.foo.checkCodeDuplicate(anyString())).thenReturn(true);

        this.mvc.perform(get("/foo/check-code-dup").param("code", "123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

}
