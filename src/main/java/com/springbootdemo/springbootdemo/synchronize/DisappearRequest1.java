package com.springbootdemo.springbootdemo.synchronize;

import sun.security.jca.GetInstance;

import javax.sound.midi.Soundbank;
import java.time.Instant;

/**
 * 消失的请求数
 */
public class DisappearRequest1 implements Runnable {

    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 =  new Thread(instance);
        Thread t2 =  new Thread(instance);
        t1.start();
        t2.start();
        //join 等待线程执行完执行后续 代码
        t1.join();
        t2.join();

        System.out.println(i);
    }


    @Override
    public void run() {
        synchronized (DisappearRequest1.class) {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }

    }
}
