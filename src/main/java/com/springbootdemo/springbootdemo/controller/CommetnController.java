package com.springbootdemo.springbootdemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//component 也能访问
@Component
@RequestMapping("component")
public class CommetnController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "ssss";
    }



}
