package com.example.springbootjunit.testng.controller;

import com.example.springbootjunit.controller.UserController;
import com.example.springbootjunit.pojo.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserControllerTest {
    @Mock
    Map<Long, User> userMap;
    @InjectMocks
    UserController userController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserList() {
        List<User> result = this.userController.getUserList();
        Assert.assertEquals(result, Arrays.<User>asList(new User(Long.valueOf(1), "name", Integer.valueOf(0))));
    }

    @Test
    public void testAddUser() {
        String result = this.userController.addUser(new User(Long.valueOf(1), "name", Integer.valueOf(0)));
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetUserById() {
        User result = this.userController.getUserById(Long.valueOf(1));
        Assert.assertEquals(result, new User(Long.valueOf(1), "name", Integer.valueOf(0)));
    }

    @Test
    public void testUpdateUser() {
        String result = this.userController.updateUser(new User(Long.valueOf(1), "name", Integer.valueOf(0)));
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testDeleteUserById() {
        String result = this.userController.deleteUserById(Long.valueOf(1));
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme