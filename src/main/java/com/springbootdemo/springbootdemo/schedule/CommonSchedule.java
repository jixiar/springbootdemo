package com.springbootdemo.springbootdemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class CommonSchedule {

    private static Random random = new Random();


    @Scheduled(cron = "* * 1-8 * * ?")
    public void cron() throws Exception {
        int value = random.nextInt(5)*1000 + 108*1000;
        //System.out.println(value);
        Thread.sleep(value);
        System.out.println("执行定时任务cron："+new Date(System.currentTimeMillis()));
    }






}
