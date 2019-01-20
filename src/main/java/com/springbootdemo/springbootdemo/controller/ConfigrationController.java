package com.springbootdemo.springbootdemo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@RequestMapping("configration")
public class ConfigrationController {
    @RequestMapping("test")
    @ResponseBody
    public String method(){
        return "configration test";
    }
}
