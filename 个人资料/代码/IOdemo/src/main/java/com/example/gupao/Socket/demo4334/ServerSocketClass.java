package com.example.gupao.Socket.demo4334;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: IOdemo
 * @description:
 * @author: wjl
 * @create: 2023-10-05 00:11
 **/
public class ServerSocketClass {
    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            //阻塞操作，等待客户端的连接
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            while(true){
                Socket socket  = serverSocket.accept();
                executorService.submit(new ServerSocketThread(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
