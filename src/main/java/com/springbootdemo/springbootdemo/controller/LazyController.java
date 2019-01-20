package com.springbootdemo.springbootdemo.controller;

import com.springbootdemo.springbootdemo.service.LazyService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
@Lazy  //懒加载 只有接口被调用时才会加载到容器中 （如果不加就是默认在spring启动时把bean加到spring容器中）
@Scope("singleton")
public class LazyController {

    private final LazyService lazyService;

    @Autowired
    public LazyController(LazyService lazyService) {
        this.lazyService = lazyService;
        System.out.println("lazy controller");
    }

    @RequestMapping("/test")
    public String test() {
        return "test hello";
    }

}
