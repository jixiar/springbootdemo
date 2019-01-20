package com.springbootdemo.springbootdemo.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequestMapping("service")
public class ServiceController {
    @RequestMapping("test")
    @ResponseBody
    public String method(){
        return "ssdd";
    }
}
