package com.springbootdemo.springbootdemo.service.imp;

import com.springbootdemo.springbootdemo.controller.LazyController;
import com.springbootdemo.springbootdemo.service.LazyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class LazyServiceImpl implements LazyService {

    public LazyServiceImpl() {
        System.out.println("load lazy service");
    }

    @Override
    public void method() {

    }
}
