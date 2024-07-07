package com.gupaoedu.pratice.day03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/19-21:32
 */
public class Demo implements Runnable{

    static ArrayBlockingQueue<String> abq=new ArrayBlockingQueue<String>(10);
    static Set<Demo> hashSet=new HashSet<>();
    @Override
    public void run() {
        String task;
        //我要回收那些临时工（最大线程的时候）
        //对于代码来说，他不需要区分核心（10）和临时. 他只要保证数量就行了（10）
        while(task=){ //take方法是阻塞的.
            try {
                abq.poll(1, TimeUnit.SECONDS); //设置超时时间.如果超时时间还没有返回的情况下，就退出阻塞状态。

                String task=abq.take(); //阻塞(阻塞超时)
                //processor(task)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo demo=new Demo(); //这个就是工作线程
        hashSet.add(demo);//把线程放到集合里面

        //线程的回收，本质上就是使得原本被阻塞的线程唤醒并且执行结束。


        boolean rs=abq.offer("abc");

    }
}
