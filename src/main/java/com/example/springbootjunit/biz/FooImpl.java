package com.example.springbootjunit.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooImpl implements Foo {
    @Autowired
    private Bar bar;

    @Override
    public boolean checkCodeDuplicate(String code) {
        return this.bar.getAllCodes().contains(code);
    }

    @Override
    public boolean checkCode(String code) {
        return true;
    }


}
