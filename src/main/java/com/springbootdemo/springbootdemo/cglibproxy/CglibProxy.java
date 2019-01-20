package com.springbootdemo.springbootdemo.cglibproxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.management.ThreadInfoCompositeData;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("事务开始。。。");
        methodProxy.invokeSuper(o,objects);
        System.out.println("事务结束。。。");
        return null;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        AddBookImpl addBook = (AddBookImpl) cglibProxy.getInstance(new AddBookImpl());
        addBook.addBook();
    }

}
