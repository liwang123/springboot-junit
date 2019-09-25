package com.example.springbootjunit.dao;

import com.example.springbootjunit.pojo.Foo;

public interface FooRepository {

    void save(Foo foo);

    void delete(String name);

    void create();

    void drop();

}
