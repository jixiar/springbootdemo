package com.springbootdemo.springbootdemo.controller;

import com.springbootdemo.springbootdemo.component.DependOnComponent;
import com.springbootdemo.springbootdemo.component.DependOnSecondComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.management.ThreadInfoCompositeData;

@Controller
@RequestMapping("/dependOn")
@DependsOn("dependOnSecondComponent")  //该bean的实例化依赖别的bean的实例化 定义bean 实例化的先后顺序
public class DependOnController {

    private DependOnSecondComponent dependOnSecondComponent;

    private DependOnComponent dependOnComponent;

    @Autowired
    public DependOnController(DependOnSecondComponent dependOnSecondComponent) {
        this.dependOnSecondComponent = dependOnSecondComponent;
        this.dependOnComponent = dependOnSecondComponent.getDepend();
    }

}
