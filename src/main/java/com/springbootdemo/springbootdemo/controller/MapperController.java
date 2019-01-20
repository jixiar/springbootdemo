package com.springbootdemo.springbootdemo.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@RequestMapping("mapper")
public class MapperController {

    @RequestMapping("test")
    @ResponseBody
    public String method(){
        return "sdfasf";
    }

}
