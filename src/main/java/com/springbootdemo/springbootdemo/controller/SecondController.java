package com.springbootdemo.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    public SecondController() {
        System.out.println("load secondcontroller");
    }

    @RequestMapping("/test")
    public String getParam(String param) {
        return param;
    }

}
