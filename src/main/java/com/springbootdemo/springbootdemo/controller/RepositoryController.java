package com.springbootdemo.springbootdemo.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@RequestMapping("repository")
public class RepositoryController {
    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "hssfds";
    }
}
