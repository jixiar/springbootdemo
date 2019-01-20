package com.springbootdemo.springbootdemo.testmain;

import com.springbootdemo.springbootdemo.annotation.Test;
import com.springbootdemo.springbootdemo.annotation.TestMethod;
import org.apache.tools.ant.taskdefs.Classloader;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.Servlet;
import java.lang.reflect.Method;

@Test()
public class AnnotationTest {
    @TestMethod("tomcat-method")
    public void test() {

    }

    public static void main(String[] args) {
        Test test = AnnotationTest.class.getAnnotation(Test.class);
        System.out.println(test.value());
        TestMethod tm = null;
        //Class ;
        //Method;
        //Servlet;

        try {
            tm = AnnotationTest.class.getDeclaredMethod("test",Integer.class).getAnnotation(TestMethod.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tm.value());
    }
}
