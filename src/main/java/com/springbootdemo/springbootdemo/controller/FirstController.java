package com.springbootdemo.springbootdemo.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
@Lazy
public class FirstController {

    public FirstController() {
        System.out.println("load firstController");
    }

    @RequestMapping("/test")
    public String getParam(String hello) {
        return hello;
    }
}
