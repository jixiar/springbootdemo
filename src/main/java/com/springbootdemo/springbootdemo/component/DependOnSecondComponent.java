package com.springbootdemo.springbootdemo.component;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * 测试bean 实例化顺序
 */
@Component
public class DependOnSecondComponent {

    public DependOnComponent getDepend() {
        return new DependOnComponent();
    }

}
