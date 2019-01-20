package com.springbootdemo.springbootdemo.synchronize;

public class SynchronizedObjectMethod3 implements Runnable {
    static SynchronizedObjectMethod3 instance = new SynchronizedObjectMethod3();

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished!");
    }

    @Override
    public void run() {
        method();
        method2();
    }

    //方法锁锁定该对象 等同 this
    public synchronized void method() {
        System.out.println("lock1我的对象锁的方法修改符形式，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"lock1运行结束。");
    }

    public synchronized void method2() {
        System.out.println("我的lock2对象锁的方法修改符形式，我叫"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"lock2运行结束。");
    }
}
