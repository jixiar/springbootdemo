package com.springbootdemo.springbootdemo.synchronize;

/**
 * 同时访问同步方法和非同步方法（普通方法 ）
 */
public class SynchronizedYesAndNo6 implements Runnable {

    static SynchronizedYesAndNo6 instance1 = new SynchronizedYesAndNo6();
    static SynchronizedYesAndNo6 instance2 = new SynchronizedYesAndNo6();

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }

    public synchronized void method1() {
        System.out.println("加锁方法，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"加锁运行结束。");
    }

    public void method2() {
        System.out.println("没加锁方法，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"没加锁运行结束。");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished!");


        //没加锁方法，我叫Thread-1
        //加锁方法，我叫Thread-0
        //Thread-1没加锁运行结束。
        //Thread-0加锁运行结束。
        //finished!

    }

}
