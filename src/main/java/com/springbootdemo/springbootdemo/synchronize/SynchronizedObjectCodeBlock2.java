package com.springbootdemo.springbootdemo.synchronize;

import java.util.Objects;

/**
 * 对象锁示例1，代码块锁
 */
public class SynchronizedObjectCodeBlock2 implements Runnable {

    static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();

    //如果需要多个同步代码块 ，需要多个锁对象，使用this会出现局限
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive()||t2.isAlive()) {  //判断当前线程是否活动，继续执行
        }
        System.out.println("finished");
    }

    @Override
    public void run() {
        synchronized (lock1) {   //如果两个线程使用的不是一个对象，或则需要锁定多个代码块同步执行，不能使用this
            System.out.println("我是lock1对象锁的代码块形式。我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1运行结果。");
        }

        synchronized (lock1) {   //如果两个线程使用的不是一个对象，或则需要锁定多个代码块同步执行，不能使用this
            System.out.println("我是lock2对象锁的代码块形式。我叫"+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock2运行结果。");
        }
    }
}
