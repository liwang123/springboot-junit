package com.example.springbootjunit.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootjunit.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author wang
 * @date
 */
@RestController
public class UserController {

    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/users")
    public List<User> getUserList() {
        List<User> list = new ArrayList<>(userMap.values());
        return list;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        userMap.put(user.getId(), user);
        Map<String, String> map = new HashMap<>();
        map.put("status", "200");
        map.put("data", JSON.toJSONString(user));
        return JSON.toJSONString(map);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userMap.get(id);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        User u = userMap.get(user.getId());
        u.setName(user.getName());
        u.setAge(user.getAge());
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userMap.remove(id);
        return "success";
    }
}
