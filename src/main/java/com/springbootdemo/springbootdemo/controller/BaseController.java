package com.springbootdemo.springbootdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    protected HttpServletRequest request;  //对继承该基类的controller 都能注入 request

    //ApplicationContextAware ;
    ApplicationContext a = new AnnotationConfigApplicationContext();


}
