package com.springbootdemo.springbootdemo.testmain;

import com.springbootdemo.springbootdemo.cglibproxy.jdkproxy.SubjectOperations;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Filter;

public class InhertTest {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.method();
        DispatcherServlet dispatcherServlet ;

    }

}

class SuperClass{

    public SuperClass() {
        System.out.println("super class");
    }

    public SuperClass(String name) {
        System.out.println("super class "+name);
    }

    public void method() {
        System.out.println("super method");
    }
}

class SubClass extends SuperClass {
    public SubClass() {
        super("tom"); //父类构造方法使用必须在子类构造方法的第一行  如果不显示调用系统会默认调用父类无参构造函数
        System.out.println("sub class");
    }

    @Override
    public void method() {
        System.out.println("sub method");
        super.method();  // 父类方法调用只能显式调用，位置可调
    }
}



