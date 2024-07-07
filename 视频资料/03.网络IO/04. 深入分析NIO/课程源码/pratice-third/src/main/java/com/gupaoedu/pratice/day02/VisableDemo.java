package com.gupaoedu.pratice.day02;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/18-20:28
 */
public class VisableDemo {

    //会有影响
    //64k ， 如果被缓存的数据是32+32， 那么在同一块
    // 缓存中可能存在两个缓存数据
    //一旦缓存失效，会导致其他和当前逻辑无关的缓存也失效.
    // [缓存填充]
    public volatile static boolean isInterrupt=false; //共享变量

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            int i=0;
            while(!isInterrupt){//循环判断| 一直占用CPU资源
                i++;
                try {
                    Thread.sleep(3000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start(); //启动线程
        System.out.println("begin start thread");
        Thread.sleep(1000); //睡眠主线程
        isInterrupt=true; //修改stop的值
    }
}
