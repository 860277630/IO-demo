package com.gupaoedu.pratice.day03;

import java.util.HashMap;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/19-20:19
 */
public class SynchronizedDemo {

    //一定是某一个方法或者代码块中可能存在线程安全问题

    /***********************/
    //this这个对象 是不是共享资源
    public synchronized void demo(){
        //synchronized (this)
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void demo4(){
        //synchronized(this){
        //
        //
        // }
    }
    /*public static void main(String[] args) {
        *//* t1和t2会互斥*//*
        //对象锁 , this代表的是sd这个实例
        SynchronizedDemo sd=new SynchronizedDemo();
        SynchronizedDemo sd1=new SynchronizedDemo();
        new Thread(()->{
            sd1.demo();
        },"t1").start();
        new Thread(()->{ //会被阻塞，直到t1线程释放了锁。
            sd1.demo4();
        },"t2").start();
    }*/
    /***********************/
    public static synchronized void demo2(){
    }
    public static synchronized void demo3(){
    }
    /*public static void main(String[] args) {
        //存在互斥
        SynchronizedDemo sd=new SynchronizedDemo();
        SynchronizedDemo sd1=new SynchronizedDemo();
        new Thread(()->{
            sd.demo2();
        },"t1").start();
        new Thread(()->{ //会被阻塞，直到t1线程释放了锁。
            sd1.demo3();
        },"t2").start();
    }*/

    //控制锁的范围，提升性能。
    //性能和安全性之间一定要做好平衡

    /**
     * synchronized锁的范围
     * 锁的对象的生命周期也决定了锁的范围
     */
    public void demo1(){
        int i=0;
        if(i==1){
            return;
        }
        synchronized (this){
            //锁定的是代码块
        }
        synchronized (SynchronizedDemo.class){

        }
    }

    public void demo7(){
        synchronized (SynchronizedDemo.class){}
    }
    public void demo8(){
        synchronized (SynchronizedDemo.class){
            //偏向锁 可以打开或者关闭（可选择）
            //线程竞争激烈程度（激烈程度（代码））
            // 来决定的： 轻量级锁(自适应自旋) -> 重量级锁
        }
    }

    public static void main(String[] args) {
        //存在互斥
        SynchronizedDemo sd=new SynchronizedDemo();
        SynchronizedDemo sd1=new SynchronizedDemo();
        new Thread(()->{
            sd.demo7();
        },"t1").start();
        new Thread(()->{ //会被阻塞，直到t1线程释放了锁。
            sd1.demo8();
        },"t2").start();
    }
}
