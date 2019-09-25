package com.example.springbootjunit.controller;

import com.example.springbootjunit.biz.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FooController {

    @Autowired
    private Foo foo;

    @RequestMapping(path = "/foo/check-code-dup", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkCodeDuplicate(@RequestParam String code) {

        return new ResponseEntity<>(
                Boolean.valueOf(this.foo.checkCodeDuplicate(code)),
                HttpStatus.OK
        );

    }


    @RequestMapping(path = "/foo/check-code", method = RequestMethod.GET)
    public ResponseEntity<Boolean> checkCode(@RequestParam String code) {

        return new ResponseEntity<>(
                Boolean.valueOf(this.foo.checkCodeDuplicate(code)),
                HttpStatus.OK
        );

    }

}
