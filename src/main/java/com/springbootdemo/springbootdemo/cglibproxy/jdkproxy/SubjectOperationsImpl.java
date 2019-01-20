package com.springbootdemo.springbootdemo.cglibproxy.jdkproxy;

public class SubjectOperationsImpl implements SubjectOperations {
    @Override
    public void print() {
        System.out.println("实现接口，完成打印操作");
    }

    @Override
    public void printfStr(String string) {
        System.out.println("打印输入的内容："+string);
    }
}
