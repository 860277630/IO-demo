package com.gupaoedu.pratice.day01;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-20:23
 */
public class ThreadDemo implements Runnable{
    @Override
    public void run() {
        //当前这个线程需要执行的代码，或者任务
        System.out.println();
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new ThreadDemo());
        thread.start();
    }
}
