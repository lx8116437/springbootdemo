package com.example.demo.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class SchedulerTask {
    private int count = 0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @Scheduled 参数可以接受两种定时的设置，
     * 一种是我们常用的cron="*\/6 * * * * ?",(具体百度cron表达式)
     * 一种是 fixedRate = 6000，
     * 两种都表示每隔六秒打印一下内容
     */
    //注释解开就可以使用了
//    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("每过6秒count增加1,当前count次数:" + (count++));
    }

    /**
     * @Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
     *
     * @Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
     *
     * @Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
     */
    //注释解开就可以使用了
//    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
