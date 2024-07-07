package com.gupaoedu.pratice.day03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/19-21:17
 */
public class TestDemo {

    //同时有1000个人用户访问
    //同时创建1000个线程
    //销毁1000个线程

    /**
     * 1. 线程频繁创建和销毁会带来性能开销
     * 2. 1000个线程想创建就创建？要做控制.
     *
     * 池化技术
     * 线程池
     */
    public void importData(){
        new Thread(()->{
            System.out.println("导入数据");
        }).start();
    }

    public static void main(String[] args) {
    /*    //创建只有一个线程的线程池
        Executors.newSingleThreadExecutor();*/
        //创建固定线程数量的线程池
       /* ExecutorService executorService=Executors.
                newFixedThreadPool(10);
        executorService.submit();
        executorService.execute();*/

      /*  //可以灵活伸缩的线程池.
        Executors.newCachedThreadPool();*/

/*
        //延时执行的任务
        Executors.newScheduledThreadPool();*/

    }
}
