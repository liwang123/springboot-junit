package com.example.springbootjunit.dao;

import com.example.springbootjunit.pojo.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FooRepositoryImpl implements FooRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Foo foo) {
        this.jdbcTemplate.update("INSERT INTO FOO(name) VALUES (?)", foo.getName());
    }

    @Override
    public void create() {
        this.jdbcTemplate.update("CREATE TABLE FOO (\n" +
                "  name VARCHAR2(100)\n" +
                "); ");
    }

    @Override
    public void drop() {
        jdbcTemplate.update("drop table FOO");
    }

    @Override
    public void delete(String name) {
        this.jdbcTemplate.update("DELETE FROM FOO WHERE NAME = ?", name);
    }

}
