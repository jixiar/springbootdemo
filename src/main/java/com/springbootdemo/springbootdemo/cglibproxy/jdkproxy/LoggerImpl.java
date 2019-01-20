package com.springbootdemo.springbootdemo.cglibproxy.jdkproxy;

public class LoggerImpl implements Logger {
    @Override
    public void logInfo() {
        System.out.println("日志记录。。。");
    }
}
