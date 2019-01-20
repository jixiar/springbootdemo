package com.springbootdemo.springbootdemo.schedule;

import java.util.Random;

public class Test {

    private static Random random = new Random();

    public static void main(String[] args) {

        String s = "1";

        String s2 = "2";

        System.out.println(s+s2);

        for (int i = 0; i < 100; i++) {

            System.out.println(random.nextInt(72));
        }
    }

}
