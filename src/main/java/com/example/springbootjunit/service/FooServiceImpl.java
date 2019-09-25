package com.example.springbootjunit.service;

import org.springframework.stereotype.Component;

@Component
public class FooServiceImpl implements FooService {

    private int count = 0;

    @Override
    public void plusCount() {
        this.count++;
    }

    @Override
    public int getCount() {
        return this.count;
    }

}
