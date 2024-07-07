package com.gupaoedu.pratice.day01;

import java.util.Queue;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-21:19
 */
public class Consumer implements Runnable{

    private Queue<String> bags; //包的集合

    public Consumer(Queue<String> bags) {
        this.bags = bags;
    }


    @Override
    public void run() {
        while(true){
            synchronized (bags){ //阻塞
                while(bags.isEmpty()){
                    System.out.println("bags为空的情况下，要生产数据");
                    try {
                        bags.wait();  //是不是阻塞消费者（队列的数据为空，是不是也需要阻塞消费者）
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String bag=bags.remove();
                System.out.println("消费者消费了一个消息："+bag);
                bags.notify();//唤醒生产者(Producer)
            }
        }
    }
}
