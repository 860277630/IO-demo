package com.gupaoedu.pratice.day01;

import java.io.File;
import java.io.FileInputStream;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-20:24
 */
public class ThreadExtendDemo extends Thread{

    public static int a=0;

    //stop() -> 从操作系统层面去终止一个线程
    //这种情况下，系统并不知道Java代码中run方法的执行情况
    @Override
    public void run() { //（Java）线程的结束，本质上是run方法的结束
        //异步执行过程
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程需要执行的任务");
    }

    public static void main(String[] args) {
        //线程的执行是由操作系统来调度的（操作系统）
        //把CPU的时间片交给某个线程来执行
        new ThreadExtendDemo().start(); //启动一个线程
        System.out.println("后续代码就不会被执行");
    }
}
