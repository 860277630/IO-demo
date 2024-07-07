package com.gupaoedu.pratice.day02;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/18-20:35
 */
public class AtomicDemo {

    private volatile static int count=0;
    static Lock lock=new ReentrantLock(); //JUC
    //通过加锁使得并发编程了串行
    public static void inc(){
        lock.lock();
        try {
            Thread.sleep(1);//？？
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++; //并不是一个原子操作integer.
        lock.unlock();
        //1.2.3
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->AtomicDemo.inc()).start();
        }
        Thread.sleep(4000); //希望所有线程运行结束
        System.out.println("运行结果："+count); //1000
    }
}
