package com.gupaoedu.pratice.day01;

import java.util.Queue;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-21:16
 */
public class Producer implements Runnable{

    //生产者和消费者都在争抢这个共享资源()
    private Queue<String> bags; //包的集合
    private int masSize; //包的数量

    public Producer(Queue<String> bags, int masSize) {
        this.bags = bags;
        this.masSize = masSize;
    }

    @Override
    public void run() {
        int i=0;
        while(true){
            i++;
            //涉及到wait/notify的方法，必须要加锁
            synchronized (bags){
                while(bags.size()==masSize){
                    //如果队列的数据满了之后，怎么处理
                    //不能再生产
                    try {
                        //会使得producer阻塞并且会释放同步锁
                        bags.wait(); //阻塞(满了之后对于当前生产者来说是否需要阻塞）
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //否则，不断的生产bag到队列中
                bags.add("bag"+i);
                System.out.println("生产者生产了一个bag：bag"+i);
                bags.notify(); //唤醒被阻塞的消费者
            }
        }
    }
}
