package com.gupaoedu.pratice.day01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-20:32
 */
public class ServerSocketDemo {


    public static void main(String[] args) {
        ServerSocket serverSocket=null;

        try {
            //向系统注册一个监听端口 8080
            serverSocket=new ServerSocket(8080);
            //建立了一个管道
            while(true) {
                //可以并行处理多个连接
                Socket socket = serverSocket.accept(); //默认情况下accept是阻塞的，直到有客户端连接过来
                //不会导致当前的进程被阻塞
                //dataSource  -> new ServerSocketThread(dataSource)
                new Thread(new ServerSocketThread(socket)).start();
                //后续的代码仍然可以被执行
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //TODO 一定要记得关闭流
        }
    }
}
