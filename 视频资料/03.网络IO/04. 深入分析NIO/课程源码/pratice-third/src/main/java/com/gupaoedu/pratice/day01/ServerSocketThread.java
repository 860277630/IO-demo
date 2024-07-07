package com.gupaoedu.pratice.day01;

import java.io.*;
import java.net.Socket;

/**
 * 腾讯课堂搜索【咕泡学院】
 * 官网：www.gupaoedu.com
 * 风骚的Mic 老师
 * create-date: 2019/12/17-20:47
 */
public class ServerSocketThread implements Runnable{
    Socket socket;

    public ServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() { //异步执行
        System.out.println("启动服务，并且获得了一个客户端连接:" + socket.getPort());
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientStr = null;
            clientStr = bufferedReader.readLine();
            System.out.println("收到客户端发过来的一条消息：" + clientStr);
            Thread.sleep(20000);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("服务端返回消息：收到了你的消息" + clientStr + "\n");
            bufferedWriter.flush(); //清空缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
