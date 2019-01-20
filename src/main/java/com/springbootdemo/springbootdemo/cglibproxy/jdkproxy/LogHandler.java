package com.springbootdemo.springbootdemo.cglibproxy.jdkproxy;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler implements InvocationHandler {

    private Object ImpClass;
    private Object object;

    public LogHandler(Object realObject){
        this.ImpClass = realObject;
    }



    public Object bind(Object impClass, Object object){
        this.ImpClass = impClass;
        this.object = object;
        return Proxy.newProxyInstance(impClass.getClass().getClassLoader(),impClass.getClass().getInterfaces(),this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("在目标方法调用前执行。。。");
        method.invoke(ImpClass,args);
        System.out.println("在目标方法调用后执行。。。");
        return null;

    }

    public static void main(String[] args) {
        SubjectOperationsImpl subjectOperations = new SubjectOperationsImpl();
        LogHandler handler = new LogHandler(subjectOperations);
        SubjectOperations subjectOperations1 = (SubjectOperations) handler.bind(subjectOperations,new LoggerImpl());
        System.out.println(subjectOperations1.getClass().getName());
        subjectOperations1.print();
        System.out.println();
        subjectOperations1.printfStr("hellp");


    }
}
