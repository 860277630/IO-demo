package com.gupaoedu.pratice.day01;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-21:34
 */
public class ThreadJoinDemo {
    static int i=0;

    // 应用框架、 kafka  redis  dubbo....

    //   设置缓冲区大小
    //   设置线程数
    //   设置堆空间大小 （并不是调优, 而是去合理的利用计算机资源）
    //            零拷贝（mmap..）， 多路复用   NIO(Netty4)通信  ->
    //            NIO    NIO     NIO
    //            算法   算法    算法
    //            JVM    C语言    JVM
    //           多线程           多线程
    //算法、 JVM 、 并发编程 、IO （用得不多）


    public void demo() throws InterruptedException {
        //TODO .
        //去导入一批数据到数据库(异步处理的方式）
        Thread t1=new Thread();
        t1.start();
        //TODO 其他逻辑的处理
        //CountDownLatch / Future/ ComplateFuture /CycliyBarrier  /...
        //我需要用到前面导入的数据进行计算, 那我怎么知道上面那个线程已经把数据导入完成了呢？
        t1.join(); //如果t1线程没有执行结束，也就是还处于存活状态，这个地方会阻塞
        // 一旦进入这段代码，意味着t1线程执行结束.
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            i=10;
        });
        Thread t2=new Thread(()->{
            i=20;
        });
        //希望其他线程对于i这个变量的值修改，对于t3线程来说，是可见的
        Thread t3=new Thread(()->{
            //用到i的值进行计算
            int x=i+40;
            //结果是多少？ 如果我们希望结果是确定的呢？
            //希望t3线程拿到的i的结果一定是20呢？
            System.out.println(x);
        });
        t1.start();
        //join中实现了线程的阻塞 。 还有唤醒(wait/notify)
        t1.join(); //是的主(main)线程阻塞在这个位置，直到t1线程执行结束以后被唤醒
        t2.start();
        t2.join();
        t3.start();
    }
}
