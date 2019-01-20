package com.springbootdemo.springbootdemo.controller;

import com.springbootdemo.springbootdemo.config.ActivityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("property")
public class PropertyController {

    @Autowired
    ActivityConfig activityConfig;

    @GetMapping("test")
    public String method() {
        return activityConfig.getEndDate().toString()+activityConfig.getStartDate().toString();
    }



}
