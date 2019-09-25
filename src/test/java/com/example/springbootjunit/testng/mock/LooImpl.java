package com.example.springbootjunit.testng.mock;

import com.example.springbootjunit.biz.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LooImpl implements Loo {

    @Autowired
    private Foo foo;

    @Override
    public boolean checkCodeDuplicate(String code) {
        return this.foo.checkCodeDuplicate(code);
    }
}
