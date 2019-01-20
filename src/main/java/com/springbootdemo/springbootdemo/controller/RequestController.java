package com.springbootdemo.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/concurrence")
public class RequestController {

    public static Set<String> set = new HashSet<>();

    @Autowired  //自动注入request
    private HttpServletRequest request;

    @RequestMapping("/test")
    public void test(HttpServletRequest request) throws InterruptedException {  //controller 方法传入request

        Thread.sleep(1000);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            System.out.println(headerNames.nextElement()+"::"+request.getHeader(header));
            //HandlerInterceptorAdapter;
            //UserRoleAuthorizationInterceptor;
            //InvocationHandler;


        }

    }




}
