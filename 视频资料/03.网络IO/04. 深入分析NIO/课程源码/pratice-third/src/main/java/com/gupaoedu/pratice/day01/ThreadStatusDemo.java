package com.gupaoedu.pratice.day01;

import java.util.concurrent.TimeUnit;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-21:02
 */
public class ThreadStatusDemo {

    public static void main(String[] args) {
        //TIME_WAITING
        new Thread(()->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"TIME_WAITING_DEMO").start();

        new Thread(()->{
            while(true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait(); //等待状态
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"WAITING_DEMO").start();

        new BlockedDemo("BLOCKEDDEMO-01").start();
        new BlockedDemo("BLOCKEDDEMO-02").start();
    }
    static class BlockedDemo extends Thread{

        public BlockedDemo(String name) {
            super(name);
        }
        @Override
        public void run() {
            synchronized (BlockedDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
