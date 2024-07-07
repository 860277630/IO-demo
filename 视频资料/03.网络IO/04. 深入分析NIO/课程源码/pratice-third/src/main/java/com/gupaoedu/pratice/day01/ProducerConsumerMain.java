package com.gupaoedu.pratice.day01;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-21:24
 */
public class ProducerConsumerMain {

    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<>();
        int masSize=10;
        Producer producer=new Producer(queue,masSize);
        Consumer consumer=new Consumer(queue);
        Thread t1=new Thread (producer);
        Thread t2=new Thread (consumer);
        t1.start();
        t2.start();
    }
}
