package com.example.springbootjunit.controller;

import com.example.springbootjunit.pojo.User;
import com.example.springbootjunit.service.UserService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnControllerMockitTest {
    @Mock
    Logger logger;

    @Mock
    UserService userService;

    @InjectMocks
    LearnController learnController;

    @MockBean
    UserService userServiceByMock;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetModel() {
        String result = this.learnController.getModel("1");
        Assert.assertEquals(result, "1");
    }

    @Test
    public void testGetUser() {
        when(this.userService.getUser("1")).thenReturn(new User(Long.valueOf(1), "qq", Integer.valueOf(18)));
        when(this.userService.getUser("2")).thenReturn(new User(Long.valueOf(2), "ww", Integer.valueOf(20)));
        User result = this.learnController.getUser("1");
        System.out.println(result);
        Assert.assertEquals(result, new User(Long.valueOf(1), "qq", Integer.valueOf(18)));
    }


    @Test
    public void testUserService() {
        User user = this.userServiceByMock.getUser("1");
        System.out.println(user);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme