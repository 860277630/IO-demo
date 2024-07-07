package com.gupaoedu.pratice.day02;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/18-21:31
 */
public class InterruptDemo implements Runnable{


    @Override
    public void run() { //线程中断的本质，在Java层面是run方法执行结束
        //这里是一个判断，判断是否被外部线程触发了中端
        //能不能中断，取决于当前的业务逻辑
        //isInterrupted 默认是false .
        //不断循环的任务呢？
        //如果是一个线程池呢？
        while(true){
            /***
             * 1
             * 2
             * 3 ->等待一个远程返回结果  Thread.sleep/ wait/ join ...
             **/
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //这里是需要处理的.
                //isInterrupted 修改为false
                Thread.currentThread().interrupt();//再中断一次
            }
            /*
             * 4
             * 5
             */
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new InterruptDemo());
        t1.start();
        Thread.sleep(1000);
        t1.interrupt(); //中断-> 修改了一个中断标识


    }
    //1~3年面试常问的面试题


}
